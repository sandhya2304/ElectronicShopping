package com.electronic.myapp.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idOrder;
	private Date dateOrder;
	
	@OneToMany(mappedBy="order")
	private Collection<LineOrder> items;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	public Order(){}

	public Order(Date dateOrder, Collection<LineOrder> items) {
		super();
		this.dateOrder = dateOrder;
		this.items = items;
	}

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Collection<LineOrder> getItems() {
		return items;
	}

	public void setItems(Collection<LineOrder> items) {
		this.items = items;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
