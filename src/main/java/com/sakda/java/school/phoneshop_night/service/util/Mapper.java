package com.sakda.java.school.phoneshop_night.service.util;

import com.sakda.java.school.phoneshop_night.dto.BrandDTO;
import com.sakda.java.school.phoneshop_night.entity.Brand;

public class Mapper {
	public static Brand toBrand(BrandDTO dto) {
		Brand brand = new Brand();
		//brand.setId(dto.getId());
		brand.setName(dto.getName());
		return brand;
	}
	
	public static BrandDTO toBrandDTO(Brand brand) {
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setName(brand.getName());
		return brandDTO;
	}
}
