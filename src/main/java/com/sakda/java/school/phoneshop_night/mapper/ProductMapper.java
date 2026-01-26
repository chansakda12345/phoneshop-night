package com.sakda.java.school.phoneshop_night.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sakda.java.school.phoneshop_night.dto.ProductDTO;
import com.sakda.java.school.phoneshop_night.dto.ProductImportDTO;
import com.sakda.java.school.phoneshop_night.entity.Product;
import com.sakda.java.school.phoneshop_night.entity.ProductImportHistory;
import com.sakda.java.school.phoneshop_night.service.ColorService;
import com.sakda.java.school.phoneshop_night.service.ModelService;

@Mapper(componentModel = "spring" , uses = {ModelService.class, ColorService.class})
public interface ProductMapper {
	
	@Mapping(target = "model" , source = "modelId")
	@Mapping(target = "color" , source = "colorId")
	Product toProduct(ProductDTO productDTO);
	
	@Mapping(target = "dateImport" , source = "importDTO.importDate")
	@Mapping(target = "pricePerUnit" , source = "importDTO.importPrice")
	@Mapping(target = "product" , source = "product")
	@Mapping(target = "id" , ignore = true)
	ProductImportHistory toProductImportHistory(ProductImportDTO importDTO, Product product);
}
