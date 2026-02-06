package com.sakda.java.school.phoneshop_night.service;

import java.time.LocalDate;
import java.util.List;

import com.sakda.java.school.phoneshop_night.projection.ProductSold;

public interface ReportService {
	List<ProductSold> getProductSold(LocalDate startDate, LocalDate endDate);
}
