package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用情况：假如有一个需求，工程运行过程中用到某个设置（如：VAR）是从环境变量中获取的，而如果用户没有在用户变量中设置这个参数，那么系统可能不会工作。这一需求有各种各样的解决办法。最好的办法就是对源码进行扩展。
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {
    public MyClassPathXmlApplicationContext(String... configLocations) {
        super(configLocations);
    }

    @Override
    protected void initPropertySources() {
        getEnvironment().setRequiredProperties("VAR");
    }
}
