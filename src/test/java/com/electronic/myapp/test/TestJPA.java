package com.electronic.myapp.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.electronic.myapp.model.Categorie;
import com.electronic.myapp.model.Product;
import com.electronic.myapp.service.IAdminCategorieService;
import com.electronic.myapp.service.IAdminProductService;

public class TestJPA {
	
	ClassPathXmlApplicationContext context;

	@Before
	public void setUp() throws Exception {
		
		
	   context =new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	
	}

	
	@Test
	public void test1()
	{
		try {
			
         
			
			IAdminCategorieService service=(IAdminCategorieService) context.getBean("service");
			
			List<Categorie> cat1=service.listCategorie();
			service.addCategorie(new Categorie("computers", "comptttttt", null,"comp.png"));
			service.addCategorie(new Categorie("Laptop", "lapttttttt", null,"lap.png"));
			
			List<Categorie> cat2=service.listCategorie();
			assertTrue(cat1.size()+2 == cat2.size());
			
			
		} catch (Exception e) 
		{
			
			assertTrue(e.getMessage(),false);
		} 
	
	}
	
	
	@Test
	public void test2()
	{
		try {
			
			IAdminCategorieService service=(IAdminCategorieService) context.getBean("service");
			
			List<Product> listproduct1=service.listproduct();
			
			service.addProduct(new Product("HP25", "HP Brand",2500,true,"hpimg.jpg",5),1L);
			service.addProduct(new Product("HP23", "HP23 Brand",2100,true,"h3img.jpg",1),1L);
			
			List<Product> listproduct2=service.listproduct();
			
			assertTrue(listproduct1.size()+2 == listproduct2.size());
			
		} catch (Exception e) 
		{
			
			assertTrue(e.getMessage(),false);
		} 
	
	}

}
