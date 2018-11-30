package com.ruanyb.spring.ioc.context;


import org.junit.Test;

import com.ruanyb.spring.ioc.HelloWorldService;

public class ApplicationContextTest {
	
	@Test
	public void test() throws Exception {
		AbstractApplicationContext abstractApplicationContext = new ClasspathXmlApplicationContext("tinyioc.xml");
		
		HelloWorldService helloWorldService = (HelloWorldService) abstractApplicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
}
