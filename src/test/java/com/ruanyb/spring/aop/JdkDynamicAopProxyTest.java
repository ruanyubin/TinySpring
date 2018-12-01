package com.ruanyb.spring.aop;


import org.junit.Test;

import com.ruanyb.spring.ioc.HelloWorldService;
import com.ruanyb.spring.ioc.HelloWorldServiceImpl;
import com.ruanyb.spring.ioc.context.ClasspathXmlApplicationContext;


public class JdkDynamicAopProxyTest {

	@Test
	public void test() throws Exception {
		ClasspathXmlApplicationContext applicationContext = new ClasspathXmlApplicationContext("tinyioc.xml");
		HelloWorldService helloWorldService = (HelloWorldServiceImpl) applicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();
		
		AdvisedSupport advisedSupport = new AdvisedSupport();
		TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldService.class);
		advisedSupport.setTargetSource(targetSource);
		
		TimerInterceptor interceptor = new TimerInterceptor();
		advisedSupport.setMethodInterceptor(interceptor);
		
		AopProxy aopProxy = new JdkDynamicAopProxy(advisedSupport); 
		
		helloWorldService = (HelloWorldService) aopProxy.getProxy();
		helloWorldService.helloWorld();
	}
		

}
