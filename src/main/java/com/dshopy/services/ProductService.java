package com.dshopy.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	public void addOrUpdateProduct(Product product, MultipartFile image) {
		product.setImageName(image.getOriginalFilename());
		product.setImageType(image.getContentType());
		try {
			product.setImageData(image.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pr.save(product);
		
	}

	public void deleteProd(int id) {
		pr.delete(getProduct(id));
		
	}

	public List<Product> search(String keyword) {
		System.out.println("searching   "+keyword);
		return pr.searchByKeyword(keyword);
	}

}
