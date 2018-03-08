package com.electronic.myapp.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electronic.myapp.model.Basket;
import com.electronic.myapp.model.Categorie;
import com.electronic.myapp.model.Client;
import com.electronic.myapp.model.LineOrder;
import com.electronic.myapp.model.Order;
import com.electronic.myapp.model.Product;
import com.electronic.myapp.model.Role;
import com.electronic.myapp.model.User;



@Repository
public class ElectronicShopImpl implements IElectronicShopDao
{
	@PersistenceContext
	private EntityManager em;
	
	

	@Override
	public Long addCategorie(Categorie c) {
		em.persist(c);
		return c.getIdCategorie();
	}

	@Override
	public List<Categorie> listCategorie() {
		Query req=em.createQuery("select c from Categorie ");
		return req.getResultList();
	}

	@Override
	public Categorie getCategorie(Long idcat) {
		return em.find(Categorie.class,idcat);
	}

	@Override
	public void removeCategorie(Long idcat) {
		Categorie c=em.find(Categorie.class,idcat);
		em.remove(c);
	}

	@Override
	public void editCategorie(Categorie c) {
		em.merge(c);
	}

	@Override
	public Long addProduct(Product p, Long idcat) {
		Categorie c=getCategorie(idcat);
		p.setCategorie(c);
		em.persist(p);
		return p.getIdProduct();
	}

	@Override
	public List<Product> listproduct() {
		Query req=em.createQuery("select p from Product p");
		return req.getResultList();
	}

	@Override
	public List<Product> productbyKeyword(String bykey) {
		Query req=em.createQuery("select p from Product p where p.designation :x or p.description :x");
		req.setParameter("x","%"+bykey+"%");
		return req.getResultList();
	}

	@Override
	public List<Product> productbyCategorie(Long idcat) {
		Query req=em.createQuery("select p from Product p where p.categorie.idCategorie =:x");
		req.setParameter("x",idcat);
		return req.getResultList();
	}

	@Override
	public List<Product> productSelected() {
		Query req=em.createQuery("select p from Product p where p.selected =true");
		return req.getResultList();
	}

	@Override
	public Product getProduct(Long idp) {
		return em.find(Product.class,idp);
		 
	}

	@Override
	public void deleteProduct(Long idp) {
		Product p=em.find(Product.class,idp);
		em.remove(p);
	}

	@Override
	public void editProduct(Product p) {
		em.merge(p);
	}

	@Override
	public void addUSer(User u) {
	  em.merge(u);
		
	}

	@Override
	public void attributeRole(Role r, Long userid) {
		User user=em.find(User.class,userid);
		user.getRole().add(r);
		
	}

	@Override
	public Order recordOrder(Basket b, Client c) {
		em.persist(c);  //first add client
		Order order=new Order();   //then create order object
		order.setDateOrder(new Date());  //second set date of order
		order.setItems(b.getItems());   //getitems from basket or cart 
		for(LineOrder lo:b.getItems())   //create a orderline depends how many order you made 
		{
			em.persist(lo);             //then add orderline
		}
		return order;
	}
	
	
	

}
