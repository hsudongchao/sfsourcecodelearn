package test.lookup;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.lookup.app.GetBeanTest;
import static org.junit.Assert.*;

/**
 * 测试获取器注入(lookup-method)
 */
public class LookupMethodTest
{
	@Test
	public void test() {
		ApplicationContext bf = new ClassPathXmlApplicationContext("test/lookup/lookupTest.xml");
		GetBeanTest test = (GetBeanTest) bf.getBean("getBeanTest");
		assertEquals("student", test.showMe());
	}
}
