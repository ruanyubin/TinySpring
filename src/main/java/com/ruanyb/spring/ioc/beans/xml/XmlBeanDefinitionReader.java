package com.ruanyb.spring.ioc.beans.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ruanyb.spring.ioc.BeanReference;
import com.ruanyb.spring.ioc.beans.AbstractBeanDefinitionReader;
import com.ruanyb.spring.ioc.beans.BeanDefinition;
import com.ruanyb.spring.ioc.beans.PropertyValue;
import com.ruanyb.spring.ioc.beans.io.ResourceLoader;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

	public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
		super(resourceLoader);
	}
	
	@Override
	public void loadBeanDefinitions(String location) throws Exception {
		InputStream inputStream = super.getResourceLoader().getResource(location).getInputStream();
		doLoadBeanDefinitions(inputStream);
	}
	
	public void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = docBuilder.parse(inputStream);
		registerBeanDefinitions(doc);
		inputStream.close();
	}
	
	public void registerBeanDefinitions(Document doc) {
		Element root = doc.getDocumentElement();
		parseBeanDefinitions(root);
	}
	
	public void parseBeanDefinitions(Element root) {
		NodeList nodeList = root.getElementsByTagName("bean");
		for(int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(node instanceof Element) {
				Element e = (Element) node;
				processBeanDefinition(e);
			}
		}
	}
	
	public void processBeanDefinition(Element e) {
		String name = e.getAttribute("name");
		String className = e.getAttribute("class");
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName(className);
		processProperty(e, beanDefinition);
		super.getRegister().put(name, beanDefinition);
	}

	private void processProperty(Element e, BeanDefinition beanDefinition) {
		
		NodeList nodelist = e.getElementsByTagName("property");
		for(int i = 0; i < nodelist.getLength(); i++) {
			Node node = nodelist.item(i);
			if(node instanceof Element) {
				Element property = (Element) node;
				String name = property.getAttribute("name");
				String value = property.getAttribute("value");
				PropertyValue propertyValue = null;
				if(value != null && value.length() > 0) {
					propertyValue = new PropertyValue(name, value);
				}else {
					String refName = property.getAttribute("ref");
					if (refName == null || refName.length() == 0) {
						throw new IllegalArgumentException("Configuration problem: <property> element for property '"
								+ name + "' must specify a ref or value");
					}
					BeanReference beanReference = new BeanReference();
					beanReference.setName(refName);
					propertyValue = new PropertyValue(name, beanReference);
				}
				beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
			}
		}
	}
	
	
}
