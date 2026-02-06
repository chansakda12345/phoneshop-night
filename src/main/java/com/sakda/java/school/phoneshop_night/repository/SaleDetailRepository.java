package com.sakda.java.school.phoneshop_night.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sakda.java.school.phoneshop_night.entity.SaleDetail;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long>
{
	List<SaleDetail> findBySaleId(Long saleId);
}
