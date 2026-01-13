package com.sakda.java.school.phoneshop_night.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sakda.java.school.phoneshop_night.entity.Model;
import com.sakda.java.school.phoneshop_night.mapper.ModelEntityMapper;
import com.sakda.java.school.phoneshop_night.repository.ModelRepository;
import com.sakda.java.school.phoneshop_night.service.ModelService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModelServiceImple implements ModelService{
	private final ModelRepository modelRepository;
	private final ModelEntityMapper modelMapper;
	
	@Override
	public Model save(Model model) {
		return modelRepository.save(model);
	}

	@Override
	public List<Model> getByBrand(Integer brandId) {
		return modelRepository.findByBrandId(brandId);
	}

}
