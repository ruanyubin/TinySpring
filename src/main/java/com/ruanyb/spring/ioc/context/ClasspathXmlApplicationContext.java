package com.ruanyb.spring.ioc.context;

import java.util.Map;
import java.util.Map.Entry;

import com.ruanyb.spring.ioc.beans.BeanDefinition;
import com.ruanyb.spring.ioc.beans.factory.AbstractBeanFactory;
import com.ruanyb.spring.ioc.beans.factory.AutowireCapableBeanFactory;
import com.ruanyb.spring.ioc.beans.io.ResourceLoader;
import com.ruanyb.spring.ioc.beans.xml.XmlBeanDefinitionReader;

public class ClasspathXmlApplicationContext extends AbstractApplicationContext {
	
	private String configLocation;
	
	public ClasspathXmlApplicationContext(String configLocation) throws Exception {
		this(configLocation, new AutowireCapableBeanFactory());
	}
	
	public ClasspathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
		super(beanFactory);
		this.configLocation = configLocation;
		refresh();
	}
	
	@Override
	public void refresh() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
		for(Entry<String, BeanDefinition> entry: xmlBeanDefinitionReader.getRegister().entrySet()) {
			super.beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
		}
	}
}
