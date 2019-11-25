package test.postprocessor;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryPostPorcessorTest
{
	@Test
	public void test_postProcessor() {
		ConfigurableListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("test/postprocessor/postprocessorTest.xml"));
		BeanFactoryPostProcessor bfpp = bf.getBean(ObscenityRemovingBeanFactoryPostProcessor.class);
		bfpp.postProcessBeanFactory(bf);
		System.out.println(bf.getBean(SimplePostProcessor.class).toString());
	}
}
