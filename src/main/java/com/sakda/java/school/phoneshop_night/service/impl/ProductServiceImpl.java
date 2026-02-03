package com.sakda.java.school.phoneshop_night.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sakda.java.school.phoneshop_night.dto.ProductImportDTO;
import com.sakda.java.school.phoneshop_night.entity.Product;
import com.sakda.java.school.phoneshop_night.entity.ProductImportHistory;
import com.sakda.java.school.phoneshop_night.exception.ApiException;
import com.sakda.java.school.phoneshop_night.exception.ResourceNotFoundException;
import com.sakda.java.school.phoneshop_night.mapper.ProductMapper;
import com.sakda.java.school.phoneshop_night.repository.ProductImportHistoryRepository;
import com.sakda.java.school.phoneshop_night.repository.ProductRepository;
import com.sakda.java.school.phoneshop_night.service.ProductService;
import org.apache.poi.ss.usermodel.Row;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
	private final ProductRepository productRepository;
	private final ProductImportHistoryRepository importHistoryRepository;
	private final ProductMapper productMapper;

	@Override
	public Product create(Product product) {
		String name = "%s %s"
				.formatted(product.getModel().getName(), product.getColor().getName());
		product.setName(name);
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", id));
	}

	@Override
	public void importProduct(ProductImportDTO importDTO) {

		Product product = getById(importDTO.getProductId());
		Integer availableUnit = 0;
		if(product.getAvailableUnit() != null) {
			availableUnit = product.getAvailableUnit();
		}
		product.setAvailableUnit(availableUnit + importDTO.getImportUnit());
		productRepository.save(product);
		
		//save product import history
		ProductImportHistory importHistory = productMapper.toProductImportHistory(importDTO, product);
		importHistoryRepository.save(importHistory);
		
	}

	@Override
	public void setSalePrice(Long productId, BigDecimal price) {
		Product product = getById(productId);
		product.setSalePrice(price);
		productRepository.save(product);
	}

	@Override
	public void validateStock(Long productId, Integer numberOfUnit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Integer, String> uploadProduct(MultipartFile file) {
		Map<Integer, String> map = new HashMap<>();
		try {
			Workbook workbook = new XSSFWorkbook(file.getInputStream());
			Sheet sheet = workbook.getSheet("products");
			Iterator<Row> rowIterator = sheet.iterator();

			rowIterator.next(); // @TODO improve checking error

			while (rowIterator.hasNext()) {
				Integer rowNumber = 0;
				try {
					Row row = rowIterator.next();
					int cellIndex = 0;
					
					Cell cellNo = row.getCell(cellIndex++);
					rowNumber = (int) cellNo.getNumericCellValue();
					
					Cell cellModelId = row.getCell(cellIndex++);
					Long modelId = (long) cellModelId.getNumericCellValue();
					
					Cell cellColorId = row.getCell(cellIndex++);
					Long colorId = (long) cellModelId.getNumericCellValue();
					
					Cell cellImportPrice = row.getCell(cellIndex++);
					Double importPrice = cellImportPrice.getNumericCellValue();
					
					Cell cellImportUnit = row.getCell(cellIndex++);
					Integer importUnit = (int) cellImportUnit.getNumericCellValue();
					if(importUnit < 1) {
						throw new ApiException(HttpStatus.BAD_REQUEST, "Unit must be greater than 0");
					}
					
					Cell cellImportDate = row.getCell(cellIndex++);
					LocalDateTime localDateTime = cellImportDate.getLocalDateTimeCellValue();
					
					Product product = getByModelIdAndColorId(modelId, colorId);
					
					Integer availableUnit = 0;
					if(product.getAvailableUnit() != null) {
						availableUnit = product.getAvailableUnit();
					}
					product.setAvailableUnit(availableUnit + importUnit);
					productRepository.save(product);
					
					//save product import history
					//ProductImportHistory importHistory = productMapper.toProductImportHistory(importDTO, product);
					ProductImportHistory importHistory = new ProductImportHistory();
					importHistory.setImportUnit(importUnit);
					importHistory.setDateImport(localDateTime);
					importHistory.setPricePerUnit(BigDecimal.valueOf(importPrice));
					importHistory.setProduct(product);
					importHistoryRepository.save(importHistory);
				} catch (Exception e) {
					map.put(rowNumber, e.getMessage());
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Product getByModelIdAndColorId(Long modelId, Long colorId) {
		String text = "Product with model id = %s and color = %d was not found";
		return productRepository.findByModelIdAndColorId(modelId, colorId)
				.orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, text.formatted(modelId, colorId)));
	}

}
