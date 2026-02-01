package com.sakda.java.school.phoneshop_night.service;

import java.math.BigDecimal;

import com.sakda.java.school.phoneshop_night.dto.ProductImportDTO;
import com.sakda.java.school.phoneshop_night.entity.Product;

public interface ProductService {
	
	Product create(Product product);
	
	Product getById(Long id);
	
	void importProduct(ProductImportDTO importDTO);
	
	void setSalePrice(Long productId, BigDecimal price);
	
	void validateStock(Long productId, Integer numberOfUnit);
	
	
}
