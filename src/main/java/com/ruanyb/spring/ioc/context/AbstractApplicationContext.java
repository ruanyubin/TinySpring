package com.ruanyb.spring.ioc.context;

import com.ruanyb.spring.ioc.beans.factory.AbstractBeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext {
	
	protected AbstractBeanFactory beanFactory;
	
	public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
		
		this.beanFactory = beanFactory;
	}
	
	public void refresh() throws Exception {
	}
	
	@Override
	public Object getBean(String name) throws Exception {
		// TODO Auto-generated method stub
		return beanFactory.getBean(name);
	}
	

}
