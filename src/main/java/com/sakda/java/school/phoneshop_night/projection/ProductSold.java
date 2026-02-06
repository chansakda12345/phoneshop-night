package com.sakda.java.school.phoneshop_night.projection;

import java.math.BigDecimal;

public interface ProductSold {
	Long getProductId();
	String getProductName();
	Integer getUnit();
	BigDecimal getTotalAmount();
}
