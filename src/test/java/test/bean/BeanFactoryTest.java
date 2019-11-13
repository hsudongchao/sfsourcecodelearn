package test.bean;

import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
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

	/**
	 * 实现BeanFactoryAware接口的bean，在被初始化之后，将会被注入BeanFactory的实例。
	 */
	@Test
	public void test_testBeanFactoryAware() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test/bean/beanFactoryTest.xml");
		TestBeanFactoryAware test = (TestBeanFactoryAware) ctx.getBean("testAware");
		test.testAware();
	}

	/**
	 * 在Spring DI注入的时候可以把普通属性注入进来，但是像Date类型就无法识别。
	 * 没有自定义属性注册编辑器时，测试不通过
	 * 解决 1. 自定义属性注册编辑器：DatePropertyEditor
	 * 	   2. 使用Spring自带的属性编辑器：CustomDateEditor
	 */
	@Test
	public void test_resourceEditorRegistrar() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test/bean/beanFactoryTest.xml");
		UserManager userManager = (UserManager) ctx.getBean("userManager");
		assertNotNull(userManager);
	}
}
