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
public class ElectronicShopDaoImpl implements IElectronicShopDao
{
	
	
	@PersistenceContext
	private EntityManager em;
	
	
	public Long addCategorie(Categorie c) {
		em.persist(c);
		return c.getIdCategorie();
	}

	public List<Categorie> listCategorie() {
		Query q=em.createQuery("select c from Categorie c");
		return q.getResultList();
	}

	public Categorie getCategorie(Long idcat) {
		return em.find(Categorie.class,idcat);
	}

	public void removeCategorie(Long idcat) {
		Categorie c=em.find(Categorie.class,idcat);
		em.remove(idcat);
	}

	public void editCategorie(Categorie c) {
		em.merge(c);
	}

	public Long addProduct(Product p, Long idcat) {
		Categorie c=getCategorie(idcat);
		p.setCategorie(c);
		em.persist(p);
		return p.getIdProduct();
	}

	public List<Product> listproduct() {
		Query q=em.createQuery("select p from Product p");
		return q.getResultList();
	}

	public List<Product> productbyKeyword(String bykey) {
		Query q=em.createQuery("select p from Product where p.designation like:x or p.description like:x");
		q.setParameter("x","%"+bykey+"%");
		return q.getResultList();
	}

	public List<Product> productbyCategorie(Long idcat) {
		Query q=em.createQuery("select p from Product where p.categorie.idCategorie=:x");
		q.setParameter("x",idcat);
		return q.getResultList();
	}

	public List<Product> productSelected() {
		Query q=em.createQuery("select p from Product where p.selected=true");
		return q.getResultList();
	}

	public Product getProduct(Long idp) {
		return em.find(Product.class,idp);
	}

	public void deleteProduct(Long idp) {
		Product p=getProduct(idp);
		em.remove(p);	
	}

	public void editProduct(Product p) {
	    em.merge(p);
	}

	public void addUSer(User u) {
		em.persist(u);
	}

	public void attributeRole(Role r, Long userid) {
		User u=em.find(User.class,userid);
		u.getRole().add(r);
		em.persist(r);
	}

	public Order recordOrder(Basket b, Client c) {
		em.persist(c);    //first add client
		Order o=new Order();  //then create order object
		o.setDateOrder(new Date());  //second set date of order
		o.setItems(b.getItems());   //getitems from basket or cart 
		for(LineOrder lo:b.getItems())    //create a orderline depends how many order you made 
		{
			em.persist(lo);     //then add orderline
		}
		em.persist(o);
		return o;
	}
	

}
