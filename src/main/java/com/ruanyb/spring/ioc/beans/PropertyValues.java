package com.ruanyb.spring.ioc.beans;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
	
	private List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();
	
	public void addPropertyValue(PropertyValue e) {
		propertyValueList.add(e);
	}
	
	public List<PropertyValue> getPropertyValues(){
		return this.propertyValueList;
	}
}
