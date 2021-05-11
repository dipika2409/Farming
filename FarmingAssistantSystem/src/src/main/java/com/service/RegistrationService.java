package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.User1;
import com.repository.RegistrationRepository;
@Service
public class RegistrationService {
	@Autowired
    private RegistrationRepository repo;
    
	
	  public User1 saveUser(User1 user1) { 
		  return repo.save(user1); } 
	  public User1
	  fetchUserByEmailId(String emailId) {
		  return repo.findByEmailId(emailId);
	  } 
	  public User1 fetchUserByEmailIdAndPassword(String emailId, String password) {
		  return repo.findByEmailIdAndPassword(emailId, password);
	  
	  }
	
	 

		/*
		 * public User1 saveUser(User1 user1) { return repo.save(user1); } public User1
		 * fetchUserByEmailId(String emailId) { return repo.findByEmailId(emailId); }
		 * public User1 fetchUserByEmailIdAndPassword(String emailId, String password) {
		 * return repo.findByEmailIdAndPassword(emailId, password);
		 * 
		 * }
		 */
}
