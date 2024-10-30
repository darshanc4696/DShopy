package com.dshopy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dshopy.models.Product;
import com.dshopy.services.ProductService;

@RestController
@RequestMapping("api")
@CrossOrigin
public class ProductController 
{
	@Autowired
	ProductService ps;
	
	@GetMapping("products")
	public List<Product> allProducts()
	{
		return ps.allProducts();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id)
	{
		Product product = ps.getProduct(id);
		if(product.getId() != 0)
			return new ResponseEntity<>(product, HttpStatus.FOUND);
		else
			return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
			
	}
	
	
}
