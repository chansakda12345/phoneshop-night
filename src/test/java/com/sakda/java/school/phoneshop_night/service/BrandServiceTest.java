package com.sakda.java.school.phoneshop_night.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sakda.java.school.phoneshop_night.entity.Brand;
import com.sakda.java.school.phoneshop_night.exception.ResourceNotFoundException;
import com.sakda.java.school.phoneshop_night.repository.BrandRepository;
import com.sakda.java.school.phoneshop_night.service.impl.BrandServiceImpl;



@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {	
	
	@Mock
	private BrandRepository brandRepository;
	
	private BrandService brandService;
	
	@BeforeEach
	public void setUp() {
		brandService = new BrandServiceImpl(brandRepository);
	}
	/*	
	@Test
	public void testCreateBrand() {
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		brand.setId(1);
		
		//when
		when(brandRepository.save(any(Brand.class))).thenReturn(brand);
		Brand brandReturn = brandService.createBrand(new Brand());
		//then
		assertEquals(1, brandReturn.getId());
		assertEquals("Apple", brandReturn.getName());
	}
	 */
	@Test
	public void testCreateBrand() {
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		//when
		brandService.createBrand(brand);
		//then
		verify(brandRepository, times(1)).save(brand);
	}
	
	@Test
	public void testGetById() {
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		brand.setId(1L);
		//when
		when(brandRepository.findById(1L)).thenReturn(Optional.of(brand));
		Brand brandReturn = brandService.getById(1L);
		//then
		assertEquals(1, brandReturn.getId());
		assertEquals("Apple", brandReturn.getName());
	}
	
	@Test
	public void testGetByIdThrow() {
		//given
		
		//when
		when(brandRepository.findById(2L)).thenReturn(Optional.empty());
		//brandService.getById(2);
		assertThatThrownBy(() -> brandService.getById(2L))
			.isInstanceOf(ResourceNotFoundException.class)
			.hasMessage("Brand with id = 2");
		//then
	}
}
