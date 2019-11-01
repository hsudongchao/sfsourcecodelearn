package test.bean;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;

public class BeanFactoryTest
{
	@Test
	public void test_beanLoad() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("test/bean/beanFactoryTest.xml"));
		MyTestBean bean = (MyTestBean) beanFactory.getBean("myTestBean");
		assertEquals("testStr", bean.getTestStr());
		Assert.isTrue("testStr".equals(bean.getTestStr()), bean::getTestStr);
	}
}
