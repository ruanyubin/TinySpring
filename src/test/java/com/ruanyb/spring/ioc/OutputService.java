package com.ruanyb.spring.ioc;

import org.junit.Assert;

/**
 * @author yihua.huang@dianping.com
 */
public class OutputService {

    private HelloWorldServiceImpl helloWorldService;

    public void output(String text){
        Assert.assertNotNull(helloWorldService);
        System.out.println(text);
    }

    public void setHelloWorldService(HelloWorldServiceImpl helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
