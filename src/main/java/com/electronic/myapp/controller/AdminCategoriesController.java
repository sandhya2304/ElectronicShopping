package com.electronic.myapp.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.electronic.myapp.model.Categorie;
import com.electronic.myapp.service.IAdminCategorieService;

@Controller
@RequestMapping(value="/adminCategories")
@SessionAttributes("editedCat")
public class AdminCategoriesController implements HandlerExceptionResolver
{
	
	@Autowired
	private IAdminCategorieService service;
	
	@RequestMapping(value="/index")
	public String index(Model model)
	{
		
		model.addAttribute("category",new Categorie());
		model.addAttribute("listCategory",service.listCategorie());
		return "categories";
	}
	
	
	@RequestMapping(value="/saveCat")
	public String save(@Valid Categorie c,BindingResult result,Model model,@RequestParam("file")MultipartFile file) throws Exception
	{
		if(result.hasErrors())
		{
			model.addAttribute("listCategory",service.listCategorie());
			return "categories";
		}
		
		if(!file.isEmpty())
		{
			BufferedImage bimg=ImageIO.read(file.getInputStream());
			c.setPhoto(file.getBytes());
			c.setNamePhoto(file.getOriginalFilename());
		}
		
		if(c.getIdCategorie()!=null)
		{			
			service.editCategorie(c);
		}
		else
		{
			service.addCategorie(c);
		}
		
		model.addAttribute("category",new Categorie());
		model.addAttribute("listCategory",service.listCategorie());
		
		return "categories";
	}
	
	@RequestMapping(value="/photoCat",produces=MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
	public byte[] photCat(@RequestParam Long idCat) throws IOException
	{
		Categorie cat=service.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(cat.getPhoto()));
		
	}
	
	
	@RequestMapping(value="/deleteCat")
	public String delete(Model model,@RequestParam Long idcat)
	{
		service.removeCategorie(idcat);
		model.addAttribute("category",new Categorie());
		model.addAttribute("listCategory",service.listCategorie());
		return "categories";
	}
	
	@RequestMapping(value="/editCat")
	public String edit(Model model,@RequestParam Long idcat)
	{
		Categorie cat=service.getCategorie(idcat);
		//model.addAttribute("editedCat",cat); //for session to fetch data
		model.addAttribute("category",cat);
		model.addAttribute("listCategory",service.listCategorie());
		return "categories";
	}
	


	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object arg2,
			Exception ex)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("categorie",new Categorie());
		mv.addObject("listCategory",service.listCategorie());
		mv.addObject("exception",ex.getMessage());
		mv.setViewName("categories");
		
		return mv;
	}
	

}
