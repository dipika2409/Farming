package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Supplier1;

public interface SupplierRepository extends JpaRepository<Supplier1, Integer>
{

	//List<Supplier1> findByName(String supplier_id);
	
	@Query("from Supplier1 where tech=?1 order by name")
	List<Supplier1> findByNameSorted(String name);
}