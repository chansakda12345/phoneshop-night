package com.sakda.java.school.phoneshop_night.service;

import com.sakda.java.school.phoneshop_night.entity.Color;

public interface ColorService {
	Color create(Color color);
	Color getById(Long id);
}
