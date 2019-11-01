package test.bean;

import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;

import java.util.PrimitiveIterator;
import java.util.logging.Level;

public class BeanFactoryTest
{
	@Test
	public void test_beanLoad() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("test/bean/beanFactoryTest.xml"));
		MyTestBean bean = (MyTestBean) beanFactory.getBean("myTestBean");
		assertEquals("testStr", bean.getTestStr());
		Assert.isTrue("testStr".equals(bean.getTestStr()), bean::getTestStr);
	}

	/**
	 * 构造器注入循环依赖测试
	 * @throws Throwable
	 */
	@Test(expected = BeanCurrentlyInCreationException.class)
	public void testCircleByConstructor() throws Throwable {
		try {
			new ClassPathXmlApplicationContext("test/bean/constructorCircleRefTest.xml");
		} catch (Exception e) {
			e.printStackTrace();
			Throwable throwable = e.getCause().getCause().getCause();
			throw throwable;
		}
	}
}
