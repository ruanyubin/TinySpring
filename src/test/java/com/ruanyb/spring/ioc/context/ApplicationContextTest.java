package com.ruanyb.spring.ioc.context;


import org.junit.Test;

import com.ruanyb.spring.ioc.HelloWorldServiceImpl;

public class ApplicationContextTest {
	
	@Test
	public void test() throws Exception {
		AbstractApplicationContext abstractApplicationContext = new ClasspathXmlApplicationContext("tinyioc.xml");
		
		HelloWorldServiceImpl helloWorldService = (HelloWorldServiceImpl) abstractApplicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
}
