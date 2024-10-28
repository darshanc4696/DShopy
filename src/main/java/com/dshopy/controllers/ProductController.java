package com.dshopy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dshopy.models.Product;
import com.dshopy.services.ProductService;

@RestController
@RequestMapping("api")
public class ProductController 
{
	@Autowired
	ProductService ps;
	
	@RequestMapping("products")
	public List<Product> allProducts()
	{
		return ps.allProducts();
	}
}
