package com.dshopy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dshopy.models.Product;
import com.dshopy.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo pr;
	
	public List<Product> allProducts()
	{
		return pr.findAll();
	}

	public Product getProduct(int id) {
		
		return pr.findById(id).orElse(new Product());
	}

}
