package test.replaced;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试方法替换(replaced-method)
 */
public class ReplacedMethodTest
{
	@Test
	public void test() {
		ApplicationContext bf = new ClassPathXmlApplicationContext("test/replaced/replacedTest.xml");
		TestChangeMethod test = (TestChangeMethod) bf.getBean("testChangeMethod");
		test.changeMe();
	}
}
