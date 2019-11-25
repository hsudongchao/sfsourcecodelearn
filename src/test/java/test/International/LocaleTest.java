package test.International;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class LocaleTest
{
	@Test
	public void test() {
		Locale locale1 = new Locale("zh", "CN");
		Locale locale2 = new Locale("zh");
		Locale locale3 = Locale.CHINA;
		Locale locale4 = Locale.CHINESE;
		Assert.assertEquals(locale1, locale3);
		Assert.assertEquals(locale2, locale4);
		System.out.println(locale1);
		System.out.println(locale2);
		System.out.println(locale3);
		System.out.println(locale4);
	}
}
