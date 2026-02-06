package com.sakda.java.school.phoneshop_night.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sakda.java.school.phoneshop_night.projection.ProductSold;
import com.sakda.java.school.phoneshop_night.repository.SaleRepository;
import com.sakda.java.school.phoneshop_night.service.ReportService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
	
	private final SaleRepository saleRepository;

	@Override
	public List<ProductSold> getProductSold(LocalDate startDate, LocalDate endDate) {
		return saleRepository.findProductSold(startDate, endDate);
	}

}
