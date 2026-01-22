package com.sakda.java.school.phoneshop_night.service;

import java.util.List;

import com.sakda.java.school.phoneshop_night.entity.Model;

public interface ModelService {
	Model save(Model model);
	List<Model> getByBrand(Long brandId);
	Model getById(Long id);
}
