package test.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.bean.MyTestBean;

public class AopTest
{
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test/aop/aopTest.xml");
		MyTestBean testBean = ctx.getBean(MyTestBean.class);
		testBean.test();
	}
}
