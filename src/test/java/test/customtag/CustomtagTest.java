package test.customtag;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomtagTest
{
	@Test
	public void test() {
		ApplicationContext bf = new ClassPathXmlApplicationContext("test/customtag/customtagTest.xml");
		User user = (User) bf.getBean("userBean");
		Assert.assertEquals("aaa", user.getUserName());
		Assert.assertEquals("bbb", user.getEmail());
	}
}
