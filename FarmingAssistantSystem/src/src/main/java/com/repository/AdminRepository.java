package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.AdminModule;

public interface AdminRepository extends JpaRepository<AdminModule, Integer>
{
	
}

