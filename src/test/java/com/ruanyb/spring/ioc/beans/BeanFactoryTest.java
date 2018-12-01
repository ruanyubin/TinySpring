package com.ruanyb.spring.ioc.beans;


import java.util.Map;

import org.junit.Test;

import com.ruanyb.spring.ioc.HelloWorldServiceImpl;
import com.ruanyb.spring.ioc.beans.BeanDefinition;
import com.ruanyb.spring.ioc.beans.factory.AbstractBeanFactory;
import com.ruanyb.spring.ioc.beans.factory.AutowireCapableBeanFactory;
import com.ruanyb.spring.ioc.beans.io.ResourceLoader;
import com.ruanyb.spring.ioc.beans.xml.XmlBeanDefinitionReader;


public class BeanFactoryTest {

	@Test
	public void test() throws Exception {
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		for(Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegister().entrySet()) {
			beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
		}
		HelloWorldServiceImpl helloWorldService = (HelloWorldServiceImpl)beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}

}
