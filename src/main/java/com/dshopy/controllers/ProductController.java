package com.dshopy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dshopy.models.Product;
import com.dshopy.services.ProductService;
import org.springframework.web.bind.annotation.RequestParam;


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
	public Product getProductById(@PathVariable int id)
	{
		Product product = ps.getProduct(id);
			return product;
			
	}
	
	@PostMapping("/product")
	public String addProduct(@RequestPart Product product, @RequestPart("imageFile") MultipartFile image)
	{
		ps.addOrUpdateProduct(product, image);
		
		return "added";
	}
	
	@GetMapping("/product/{id}/image")
	public byte[] fetchImage(@PathVariable("id") int id)
	{
		Product product = ps.getProduct(id);
		
		return product.getImageData();
	}
	
	@PutMapping("/product/{id}")
	public void updateProduct(@RequestPart Product product, @RequestPart("imageFile") MultipartFile image, @PathVariable("id") int id)
	{
		ps.addOrUpdateProduct(product, image);
		
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable("id") int id)
	{
		ps.deleteProd(id);
	}
	
	@GetMapping("/products/search")
	public List<Product> getMethodName(@RequestParam("keyword") String keyword) {
		return ps.search(keyword); 
	}
	
	
	
	
	
}
