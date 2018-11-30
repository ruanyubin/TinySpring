package com.ruanyb.spring.ioc.beans.io;


import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import com.ruanyb.spring.ioc.beans.io.ResourceLoader;

public class ResourceLoaderTest {

	@Test
	public void test() throws IOException {
		ResourceLoader resourceLoader = new ResourceLoader();
		InputStream inputStream = resourceLoader.getResource("tinyioc.xml").getInputStream();
		Assert.assertNotNull(inputStream);
		inputStream.close();
	}

}
