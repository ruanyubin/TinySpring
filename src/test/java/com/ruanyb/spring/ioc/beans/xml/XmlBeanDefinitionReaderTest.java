package com.ruanyb.spring.ioc.beans.xml;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.ruanyb.spring.ioc.beans.BeanDefinition;
import com.ruanyb.spring.ioc.beans.io.ResourceLoader;
import com.ruanyb.spring.ioc.beans.xml.XmlBeanDefinitionReader;

import junit.framework.Assert;

public class XmlBeanDefinitionReaderTest {

	@Test
	public void test() throws Exception {
		ResourceLoader resourceLoader = new ResourceLoader();
		XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(resourceLoader);
		xmlReader.loadBeanDefinitions("tinyioc.xml");
		Map<String, BeanDefinition> register = xmlReader.getRegister();
		Assert.assertTrue(register.size() > 0 == true);
	}

}
