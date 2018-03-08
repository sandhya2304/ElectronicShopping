package com.electronic.myapp.dao;

import java.util.List;

import com.electronic.myapp.model.*;

public interface IElectronicShopDao 
{
	
	public Long addCategorie(Categorie c);
	public List<Categorie> listCategorie();
	public Categorie getCategorie(Long idcat);
	public void removeCategorie(Long idcat);
	public void editCategorie(Categorie c);
	
	public Long addProduct(Product p,Long idcat);
	public List<Product> listproduct();
	public List<Product> productbyKeyword(String bykey);
	public List<Product> productbyCategorie(Long idcat);
	public List<Product> productSelected();
	public Product getProduct(Long idp);
	public void deleteProduct(Long idp);
	public void editProduct(Product p);
	
	public void addUSer(User u);
	public void attributeRole(Role r,Long userid);
	public Order recordOrder(Basket b,Client c);
	

}
