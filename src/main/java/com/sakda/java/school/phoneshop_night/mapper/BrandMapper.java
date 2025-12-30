package com.sakda.java.school.phoneshop_night.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sakda.java.school.phoneshop_night.dto.BrandDTO;
import com.sakda.java.school.phoneshop_night.entity.Brand;

@Mapper
public interface BrandMapper {
	BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
	Brand toBrand(BrandDTO dto);
	BrandDTO toBrandDTO(Brand entity);
}
