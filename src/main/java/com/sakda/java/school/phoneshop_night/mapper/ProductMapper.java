package com.sakda.java.school.phoneshop_night.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sakda.java.school.phoneshop_night.dto.ProductDTO;
import com.sakda.java.school.phoneshop_night.entity.Product;
import com.sakda.java.school.phoneshop_night.service.ColorService;
import com.sakda.java.school.phoneshop_night.service.ModelService;

@Mapper(componentModel = "spring" , uses = {ModelService.class, ColorService.class})
public interface ProductMapper {
	
	@Mapping(target = "model" , source = "modelId")
	@Mapping(target = "color" , source = "colorId")
	Product toProduct(ProductDTO productDTO);
}
