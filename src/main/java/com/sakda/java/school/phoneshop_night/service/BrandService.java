package com.sakda.java.school.phoneshop_night.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.sakda.java.school.phoneshop_night.entity.Brand;

public interface BrandService {
	Brand createBrand(Brand brand);
	Brand getById(Long id);
	Brand update(Long id, Brand brandUpdate);
	List<Brand> getBrands(String name);
	//List<Brand> getBrands(Map<String, String> params);
	Page<Brand> getBrands(Map<String, String> params);
}
