package com.demo.test;


import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringJunitTest {

    protected static ApplicationContext acx;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        acx=new ClassPathXmlApplicationContext("applicationContext-bean.xml");
    }

}  
