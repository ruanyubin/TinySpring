package com.ruanyb.spring.ioc.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropertyValue {
	
	private String name;
	private Object value;
	
}