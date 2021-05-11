package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.User1;
public interface RegistrationRepository extends JpaRepository<User1, Integer> {
	
	  
	 
	  
	  
	public User1 findByEmailId(String emailId);
	public User1 findByEmailIdAndPassword(String emailId, String password);
	

}
