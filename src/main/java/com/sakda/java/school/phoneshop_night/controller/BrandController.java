package com.sakda.java.school.phoneshop_night.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sakda.java.school.phoneshop_night.dto.BrandDTO;
import com.sakda.java.school.phoneshop_night.entity.Brand;
import com.sakda.java.school.phoneshop_night.service.BrandService;
import com.sakda.java.school.phoneshop_night.service.util.Mapper;

@RestController
@RequestMapping("brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@RequestMapping(method = RequestMethod.POST)
	//@PostMapping
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		Brand brand = Mapper.toBrand(brandDTO);
		brand = brandService.createBrand(brand);
		return ResponseEntity.ok(Mapper.toBrandDTO(brand));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId){
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(Mapper.toBrandDTO(brand));
	}
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO){
		Brand brand = Mapper.toBrand(brandDTO);
		Brand updatedBrand = brandService.update(brandId, brand);
		return ResponseEntity.ok(Mapper.toBrandDTO(updatedBrand));
	}
}
