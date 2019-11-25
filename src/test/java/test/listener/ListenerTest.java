package test.listener;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ListenerTest
{
	@Test
	public void test_listener() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test/listener/listenerTest.xml");
		TestEvent testEvent = new TestEvent("hello", "msg");
		ctx.publishEvent(testEvent);
	}
}
