package com.electronic.myapp.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Basket 
{
	Map<Long,LineOrder> items=new HashMap<Long, LineOrder>();
	
	public void addArticle(Product product,int quantity)
	{
		if(items.get(product.getIdProduct())==null)
		{
			LineOrder lineorder=new LineOrder();
			lineorder.setProduct(product);
			lineorder.setPrice(product.getPrice());
			lineorder.setQuantity(product.getQuantity());			
		}
		else
		{
			LineOrder line2=new LineOrder();
			line2.setQuantity(line2.getQuantity()+quantity);
		}
	}
	
	public Collection<LineOrder> getItems()
	{
		return items.values();
	}
	
	public double getTotal()
	{
		double total=0;
		for(LineOrder lineorder:items.values())
		{
			total+=lineorder.getPrice()*lineorder.getQuantity();			
		}
		return total;
	}
	
	public int getSize()
	{
		return items.size();
	}
	
	public void deleteItem(Long idProduct)
	{
		items.remove(idProduct);
	}

}
