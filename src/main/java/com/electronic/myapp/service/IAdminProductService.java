package com.electronic.myapp.service;

import com.electronic.myapp.model.Product;

public interface IAdminProductService  extends IUserService{
	
	
	public Long addProduct(Product p,Long idcat);
	public void deleteProduct(Long idp);
	public void editProduct(Product p);

	
	

}
