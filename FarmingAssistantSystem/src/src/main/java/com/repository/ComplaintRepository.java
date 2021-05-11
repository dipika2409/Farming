package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{

	@Query("from Complaint where complaint_status=?1 order by complaint_status")
	List<Complaint> findByStatusSorted(String complaint_status);

	

}
