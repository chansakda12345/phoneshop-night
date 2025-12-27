package com.sakda.java.school.phoneshop_night.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakda.java.school.phoneshop_night.entity.Brand;
import com.sakda.java.school.phoneshop_night.repository.BrandRepository;
import com.sakda.java.school.phoneshop_night.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Brand createBrand(Brand brand) {
		return brandRepository.save(brand);
	}

}
