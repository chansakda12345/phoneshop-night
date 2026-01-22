package com.sakda.java.school.phoneshop_night.service;

import com.sakda.java.school.phoneshop_night.entity.Product;

public interface ProductService {
	
	Product create(Product product);
	
	Product getById(Long id);
}
