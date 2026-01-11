package com.sakda.java.school.phoneshop_night.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakda.java.school.phoneshop_night.dto.ModelDTO;
import com.sakda.java.school.phoneshop_night.entity.Model;
import com.sakda.java.school.phoneshop_night.mapper.ModelMapper;
import com.sakda.java.school.phoneshop_night.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
	
	private final ModelService modelService;
	private final ModelMapper modelMapper;
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO){
		Model model = modelMapper.toModel(modelDTO);
		model = modelService.save(model);
		return ResponseEntity.ok(modelMapper.toModelDTO(model));
	}

}
