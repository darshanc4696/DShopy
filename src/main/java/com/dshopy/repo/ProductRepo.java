package com.dshopy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dshopy.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{


}
