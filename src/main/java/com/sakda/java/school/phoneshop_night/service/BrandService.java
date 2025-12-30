package com.sakda.java.school.phoneshop_night.service;

import java.util.List;

import com.sakda.java.school.phoneshop_night.entity.Brand;

public interface BrandService {
	Brand createBrand(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id, Brand brandUpdate);
	List<Brand> getBrands();
	List<Brand> getBrands(String name);
}
