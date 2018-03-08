package com.electronic.myapp.service;

import java.util.List;

import com.electronic.myapp.model.*;

public interface IUserService 
{
	
	public List<Categorie> listCategorie();
	public Categorie getCategorie(Long idcat);
	public List<Product> listproduct();
	public List<Product> productbyKeyword(String bykey);
	public List<Product> productbyCategorie(Long idcat);
	public List<Product> productSelected();
	public Product getProduct(Long idp);
	public Order recordOrder(Basket b,Client c);

}
