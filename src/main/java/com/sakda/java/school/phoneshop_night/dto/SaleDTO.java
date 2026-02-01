package com.sakda.java.school.phoneshop_night.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class SaleDTO {
	@NotEmpty
	private List<ProductSoldDTO> products;
	private LocalDateTime saleDate;

}
