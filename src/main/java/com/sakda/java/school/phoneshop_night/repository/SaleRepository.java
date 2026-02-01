package com.sakda.java.school.phoneshop_night.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sakda.java.school.phoneshop_night.entity.Product;
import com.sakda.java.school.phoneshop_night.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{
	
}
