package com.electronic.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electronic.myapp.dao.IElectronicShopDao;
import com.electronic.myapp.model.Basket;
import com.electronic.myapp.model.Categorie;
import com.electronic.myapp.model.Client;
import com.electronic.myapp.model.Order;
import com.electronic.myapp.model.Product;
import com.electronic.myapp.model.Role;
import com.electronic.myapp.model.User;


@Service
@Transactional
public class ElectronicServiceImpl implements IAdminCategorieService
{
	
	@Autowired
	private IElectronicShopDao dao;
	
	
	public void setDao(IElectronicShopDao dao) {
		this.dao = dao;
	}
	

	@Override
	public List<Categorie> listCategorie() {
		return dao.listCategorie();
	}

	@Override
	public Categorie getCategorie(Long idcat) {
		return dao.getCategorie(idcat);
	}

	@Override
	public List<Product> listproduct() {
		return dao.listproduct();
	}

	@Override
	public List<Product> productbyKeyword(String bykey) {
		return dao.productbyKeyword(bykey);
	}

	@Override
	public List<Product> productbyCategorie(Long idcat) {
		return dao.productbyCategorie(idcat);
	}

	@Override
	public List<Product> productSelected() {
		return dao.productSelected();
	}

	@Override
	public Product getProduct(Long idp) {
		return dao.getProduct(idp);
	}

	@Override
	public Order recordOrder(Basket b, Client c) {
		return dao.recordOrder(b, c);
	}

	@Override
	public Long addProduct(Product p, Long idcat) {
		return dao.addProduct(p, idcat);
	}

	@Override
	public void deleteProduct(Long idp) {
	   dao.deleteProduct(idp);
	}

	@Override
	public void editProduct(Product p) {
		dao.editProduct(p);
	}


	@Override
	public Long addCategorie(Categorie c) {
		return dao.addCategorie(c);
	}


	@Override
	public void removeCategorie(Long idcat) {
		dao.removeCategorie(idcat);
	}


	@Override
	public void editCategorie(Categorie c) {
		dao.editCategorie(c);
	}


	@Override
	public void addUSer(User u) {
		dao.addUSer(u);
	}


	@Override
	public void attributeRole(Role r, Long userid) {
		dao.attributeRole(r, userid);
	}
	
	
	

}
