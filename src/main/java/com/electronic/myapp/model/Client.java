package com.electronic.myapp.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idClient;
	private String nameClient;
	private String address;
	private String email;
	private String telephone;
	
	@OneToMany(mappedBy="client")
	private Collection<Order> order;
	
	public Client (){}

	public Client(String nameClient, String address, String email,
			String telephone) {
		super();
		this.nameClient = nameClient;
		this.address = address;
		this.email = email;
		this.telephone = telephone;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Collection<Order> getOrder() {
		return order;
	}

	public void setOrder(Collection<Order> order) {
		this.order = order;
	}
	
	

}
