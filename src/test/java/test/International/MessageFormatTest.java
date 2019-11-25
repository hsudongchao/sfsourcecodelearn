package test.International;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MessageFormatTest
{
	@Test
	public void test() {
		String pattern1 = "{0}，您好！您于{1}在工商银行存入{2} 元";
		String pattern2 = "At {1,time,short} On {1,date,long}, {0} paid {2,number,currency}.";
		Object[] params = {"John", new GregorianCalendar().getTime(), 1.0E3};
		// 使用默认本地化对象格式化信息
		String msg1 = MessageFormat.format(pattern1, params);
		// 使用指定的本地化对象格式化信息
		MessageFormat mf = new MessageFormat(pattern2, Locale.US);
		String msg2 = mf.format(params);
		System.out.println(msg1);
		System.out.println(msg2);
	}

	@Test
	public void test_messageSource() {
		String[] configs = {"test/international/internationalTest.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
		Object[] params = {"John", new GregorianCalendar().getTime()};
		String str1 = ctx.getMessage("test", params, Locale.US);
		String str2 = ctx.getMessage("test", params, Locale.CHINA);
		System.out.println(str1);
		System.out.println(str2);
	}
}
