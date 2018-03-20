package com.electronic.myapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author dlc
 *
 */
@Entity
@Table(name="product")
public class Product implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idProduct;
	@NotEmpty
	@Size(min=1,max=20)
	private String designation;
	private String description;
    private double price;
    private boolean selected;
    private String photo;
    private int quantity;
    
    
    @ManyToOne
    @JoinColumn(name="idCategorie")
    private Categorie categorie;
    
    public Product(){}
    
    
	public Product(String designation, String description, double price,
			boolean selected, String photo, int quantity) {
		super();
		this.designation = designation;
		this.description = description;
		this.price = price;
		this.selected = selected;
		this.photo = photo;
		this.quantity = quantity;
	}


	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
    
    
}
