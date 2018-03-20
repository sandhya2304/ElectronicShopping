package com.electronic.myapp.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.electronic.myapp.model.Categorie;
import com.electronic.myapp.model.Product;
import com.electronic.myapp.service.IAdminProductService;

@Controller
@RequestMapping(value="/adminProd")
public class AdminProductController
{
	
	@Autowired
	private IAdminProductService service;
	
	@RequestMapping(value="/adminProd")
	private String index(Model model)
	{
		
		model.addAttribute("product",new Product());
		model.addAttribute("listProduct",service.listproduct());
		model.addAttribute("categories",service.listCategorie());
		
		return "products";
	}
	
	
	@RequestMapping(value="/saveProd",method=RequestMethod.POST)
	public String saveProd(@Valid Product p,BindingResult result,Model model,@RequestParam("file") MultipartFile file)
			throws Exception
	{
		if(result.hasErrors())
		{
			model.addAttribute("listCategory",service.listCategorie());
			model.addAttribute("listProduct",service.listproduct());
			return "products";
		}
		// Here we want to embed in file format

		String path=System.getProperty("java.io.tmpdir");
		
		
		if(!file.isEmpty())
		{
			p.setPhoto(file.getOriginalFilename());
			Long idP=service.addProduct(p, p.getCategorie().getIdCategorie());
			
			file.transferTo(new File(path+"/"+"PROD_"+idP+"_"+file.getOriginalFilename()));			
		}
		else
		{
			p.setCategorie(service.getCategorie(p.getCategorie().getIdCategorie()));
			service.addProduct(p, p.getCategorie().getIdCategorie());
			
		}
		
		model.addAttribute("product",new Product());
		model.addAttribute("listProduct",service.listproduct());
		model.addAttribute("categories",service.listCategorie());
		
		return "products";
	}
	
	@RequestMapping(value="ProdPhoto",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoProd(@RequestParam Long idProd) throws FileNotFoundException, IOException
	{
		Product p=service.getProduct(idProd);
		File file=new File(System.getProperty("java.io.tmpdir")+"/"+"PROD_"+idProd+"_"+p.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(file));
	}
	
	@RequestMapping(value="deleteProd",method=RequestMethod.GET)
	public String deleteProduct(@RequestParam Long idProd,Model model)
	{
		service.deleteProduct(idProd);
		model.addAttribute("product",new Product());
		model.addAttribute("listProduct",service.listproduct());
		model.addAttribute("categories",service.listCategorie());
		model.addAttribute("product",new Product());
		
		return "products";
		
	}
	

	@RequestMapping(value="/editProd",method=RequestMethod.GET)
	public String edit(Model model,@RequestParam Long idProd)
	{
		model.addAttribute("listProduct",service.listproduct());
		model.addAttribute("listCategory",service.listCategorie());
		model.addAttribute("product",service.getProduct(idProd));
		
		return "products";
	}
	
	
	

}
