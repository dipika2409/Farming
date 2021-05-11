package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.model.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer,Integer> {
	
	@Query("from Farmer where first_name=?1 order by first_name")
	List<Farmer> findByfirst_name(String first_name);
	
//	@Query("from Farmer where first_name=?1 Like R%")
//	List<Farmer> findByfirst_name1(String first_name);

}
