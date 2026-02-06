package com.sakda.java.school.phoneshop_night.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sakda.java.school.phoneshop_night.entity.Sale;
import com.sakda.java.school.phoneshop_night.projection.ProductSold;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>
{
	@Query(value = "select p.id as productId, p.name as productName, sum(sd.unit) unit, sum(sd.unit * sd.amount) totalAmount \r\n"
			+ "from sale_details sd\r\n"
			+ "inner join sales s on sd.sale_id = s.sale_id\r\n"
			+ "inner join products p on p.id = sd.product_id\r\n"
			+ "where date(s.sold_date) >= :startDate and date(s.sold_date) <= :endDate\r\n"
			+ "group by p.id, p.name"
			+ "", nativeQuery = true)
	List<ProductSold> findProductSold(LocalDate startDate, LocalDate endDate);
}
