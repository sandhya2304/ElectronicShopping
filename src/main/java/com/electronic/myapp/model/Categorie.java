package com.electronic.myapp.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Categorie
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCategorie;
	@NotEmpty
	@Size(min=3,max=20)
	private String nameCategory;
	private String description;
	@Lob
	private byte[] photo;
	private  String namePhoto;
	@OneToMany(mappedBy="categorie")
	private Collection<Product> product;
	
	public Categorie(){}
	
	
	public Categorie(String nameCategory, String description, byte[] photo,
			String namePhoto) {
		super();
		this.nameCategory = nameCategory;
		this.description = description;
		this.photo = photo;
		this.namePhoto = namePhoto;
	}


	public Long getIdCategorie() {
		return idCategorie;
	}


	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}


	public String getNameCategory() {
		return nameCategory;
	}


	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


	public String getNamePhoto() {
		return namePhoto;
	}


	public void setNamePhoto(String namePhoto) {
		this.namePhoto = namePhoto;
	}


	public Collection<Product> getProduct() {
		return product;
	}


	public void setProduct(Collection<Product> product) {
		this.product = product;
	}



	

}