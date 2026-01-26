package com.sakda.java.school.phoneshop_night.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sakda.java.school.phoneshop_night.dto.ProductImportDTO;
import com.sakda.java.school.phoneshop_night.entity.Product;
import com.sakda.java.school.phoneshop_night.entity.ProductImportHistory;
import com.sakda.java.school.phoneshop_night.exception.ApiException;
import com.sakda.java.school.phoneshop_night.exception.ResourceNotFoundException;
import com.sakda.java.school.phoneshop_night.mapper.ProductMapper;
import com.sakda.java.school.phoneshop_night.repository.ProductImportHistoryRepository;
import com.sakda.java.school.phoneshop_night.repository.ProductRepository;
import com.sakda.java.school.phoneshop_night.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
	private final ProductRepository productRepository;
	private final ProductImportHistoryRepository importHistoryRepository;
	private final ProductMapper productMapper;

	@Override
	public Product create(Product product) {
		String name = "%s %s"
				.formatted(product.getModel().getName(), product.getColor().getName());
		product.setName(name);
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", id));
	}

	@Override
	public void importProduct(ProductImportDTO importDTO) {

		Product product = getById(importDTO.getProductId());
		Integer availableUnit = 0;
		if(product.getAvailableUnit() != null) {
			availableUnit = product.getAvailableUnit();
		}
		product.setAvailableUnit(availableUnit + importDTO.getImportUnit());
		productRepository.save(product);
		
		//save product import history
		ProductImportHistory importHistory = productMapper.toProductImportHistory(importDTO, product);
		importHistoryRepository.save(importHistory);
		
	}
	
}
