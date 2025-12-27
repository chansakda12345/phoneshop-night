package com.sakda.java.school.phoneshop_night.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sakda.java.school.phoneshop_night.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
