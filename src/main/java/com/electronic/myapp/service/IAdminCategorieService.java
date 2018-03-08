package com.electronic.myapp.service;

import com.electronic.myapp.model.Categorie;
import com.electronic.myapp.model.Role;
import com.electronic.myapp.model.User;

public interface IAdminCategorieService extends IAdminProductService
{
	
	public Long addCategorie(Categorie c);
	public void removeCategorie(Long idcat);
	public void editCategorie(Categorie c);
	public void addUSer(User u);
	public void attributeRole(Role r,Long userid);


}
