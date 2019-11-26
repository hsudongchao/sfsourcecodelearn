package test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AspectJTest
{
	private static final Logger logger = LoggerFactory.getLogger(AspectJTest.class);
	@Pointcut("execution(* *.test(..))")
	public void test() {}

	@Before("test()")
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@After("test()")
	public void afterTest() {
		System.out.println("afterTest");
	}

	@Around(("test()"))
	public Object arountTest(ProceedingJoinPoint p) {
		System.out.println("before1");
		Object o = null;
		try {
		    o = p.proceed();
		}
		catch(Throwable e) {
			logger.error("error : " + e.getMessage(), e);
		}
		System.out.println("after1");
		return o;
	}
}
