package com.sakda.java.school.phoneshop_night.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakda.java.school.phoneshop_night.entity.Brand;
import com.sakda.java.school.phoneshop_night.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Long>{
	List<Model> findByBrandId(Long brandId);
}
