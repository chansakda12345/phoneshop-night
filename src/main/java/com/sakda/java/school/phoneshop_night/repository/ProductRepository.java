package com.sakda.java.school.phoneshop_night.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sakda.java.school.phoneshop_night.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>
{
	Optional<Product> findByModelIdAndColorId(Long modelId, Long colorId);
}
