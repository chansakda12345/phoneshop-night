package com.sakda.java.school.phoneshop_night.service;

import com.sakda.java.school.phoneshop_night.entity.Brand;

public interface BrandService {
	Brand createBrand(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id, Brand brandUpdate);
}
