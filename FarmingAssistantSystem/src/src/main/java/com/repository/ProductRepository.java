package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query("from Product where product_status=?1 order by product_status")
	List<Product> findByStatusSorted(String product_status);


}