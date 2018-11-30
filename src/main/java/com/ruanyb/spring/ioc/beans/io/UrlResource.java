package com.ruanyb.spring.ioc.beans.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlResource implements Resource {
	
	private URL url; 
	
	public UrlResource(URL url) {
			this.url = url;
	}
	
	@Override
	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		 URLConnection connection = url.openConnection();
		return connection.getInputStream();
	}

}
