package com.electronic.myapp.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {

	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void test1()
	{
		try {
			ClassPathXmlApplicationContext context
			    =new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			assertTrue(true);
			
		} catch (Exception e) 
		{
			
			assertTrue(e.getMessage(),false);
		} 
		
		
		
	}

}
