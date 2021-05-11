package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ComplaintNotFoundException;
import com.model.AdminModule;
import com.model.Complaint;
import com.model.Farmer;
import com.model.Notification;
import com.repository.AdminRepository;
import com.repository.ComplaintRepository;
import com.repository.FarmerRepository;
import com.repository.NotificationRepository;

@Service
public class AdminService {

	List<Farmer> ls;
	List<AdminModule> le;
	List<Complaint> la;
	List<Complaint> lc;
List<Notification> ne;
	
	@Autowired
	NotificationRepository notrepo;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	FarmerRepository farrepo;
	
	@Autowired
	private ComplaintRepository carrepo;
	
	@Autowired(required = true)
	ComplaintRepository comrepo;

	public List<AdminModule> getAdminDetail() {
		// TODO Auto-generated method stub
		le=new ArrayList();
		le=adminRepository.findAll(); 
		return le;
	
	}

public List<Notification> getNoti(){
	ne = new ArrayList();
	ne = notrepo.findAll();
	return ne;
}

	public List<Farmer> getFarmers() {
		// TODO Auto-generated method stub
		

		ls=new ArrayList();
		ls=farrepo.findAll(); 
		return ls;
		
	}

	public List<Complaint> getComp() {
		// TODO Auto-generated method stub
		lc=new ArrayList(); 
		lc=comrepo.findAll();
		return lc;
	}
	
	public AdminModule createDetails(AdminModule a) {
		// TODO Auto-generated method stub
		AdminModule c1=adminRepository.save(a);
		
		return c1;
	}
	
	public Complaint updateComp(Complaint c) throws Exception {
		// TODO Auto-generated method stub

				int id = c.getComplaint_id();
				Supplier<Exception> s1 = ()->new ComplaintNotFoundException("Complaint id is not present in the database");
				Complaint c1=carrepo.findById(id).orElseThrow(s1);
				c1.setComplaint_status(c.getComplaint_status());
			
				carrepo.save(c1);
				return c1;	
	}
}
