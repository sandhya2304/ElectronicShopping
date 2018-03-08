package com.electronic.myapp.service;

import java.util.List;

import com.electronic.myapp.dao.IElectronicShopDao;
import com.electronic.myapp.model.Basket;
import com.electronic.myapp.model.Categorie;
import com.electronic.myapp.model.Client;
import com.electronic.myapp.model.Order;
import com.electronic.myapp.model.Product;

public class ElectronicServiceImpl implements IAdminProductService
{
	
	private IElectronicShopDao dao;
	
	public void setDao(IElectronicShopDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Categorie> listCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getCategorie(Long idcat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listproduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> productbyKeyword(String bykey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> productbyCategorie(Long idcat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> productSelected() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProduct(Long idp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order recordOrder(Basket b, Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long addProduct(Product p, Long idcat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Long idp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editProduct(Product p) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
