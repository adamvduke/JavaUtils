package org.ate.util.test;

import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class BaseUtilTest{

	protected static ClassPathXmlApplicationContext context;

	/**
	 * Setup the Spring context for any subclasses
	 */
	@BeforeClass
	public static void setupContext(){
		context = new ClassPathXmlApplicationContext("classpath:/util-spring-beans.xml");
	}

	/**
	 * Force subclasses to do any necessary setup
	 */
	protected abstract void setup();
}
