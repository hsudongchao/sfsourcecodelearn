package test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import test.bean.MyTestBean;

public class MyClassPathXmlApplicationContextTest {
    @Test
    public void test() {
        ApplicationContext applicationContext = new MyClassPathXmlApplicationContext("/test/bean/beanFactoryTest.xml");
        MyTestBean testBean = applicationContext.getBean(MyTestBean.class);
        Assert.assertNotNull(testBean);
    }
}
