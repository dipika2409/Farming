package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ComplaintNotFoundException;
import com.model.Complaint;
import com.repository.ComplaintRepository;

@Service
public class ComplaintService {

	List<Complaint> le;
	
	@Autowired(required = true)
	ComplaintRepository comrepo;
	



	public Complaint createComplaint(Complaint c) {
		// TODO Auto-generated method stub
		Complaint c1=comrepo.save(c);
		
		return c1;
	}



	public List<Complaint> getComp() {
		// TODO Auto-generated method stub
		le=new ArrayList(); 
		le=comrepo.findAll();
		return le;
	}



	public Complaint getComById(int complaint_id) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s2=()-> new ComplaintNotFoundException ("Complaint is not present in the database");
		Complaint c1 = comrepo.findById(complaint_id).orElseThrow(s2);
		return c1;
	}



	public List<Complaint> addComp(List<Complaint> ls) {
		// TODO Auto-generated method stub
		le = new ArrayList<>();
		le = comrepo.saveAll(ls);
		return le;
	}



	public Complaint updateComp(Complaint c) throws Exception {
		// TODO Auto-generated method stub
		int id = c.getComplaint_id();
		Supplier<Exception> s1 = ()->new ComplaintNotFoundException("Complaint id is not present in the database");
		Complaint c1=comrepo.findById(id).orElseThrow(s1);
		c1.setComplaint_text(c.getComplaint_text());
		c1.setComplaint_status(c.getComplaint_status());
	
		comrepo.save(c1);
		return c1;	
		}



	public Complaint deleteComp(int complaint_id ) {
			Complaint c1=comrepo.findById(complaint_id).orElse(null);
			
			comrepo.deleteById(complaint_id);
			return c1;
			
	}	 



	public String deleteCompById(int complaint_id) {
		// TODO Auto-generated method stub
		Complaint c1 = comrepo.findById(complaint_id).orElse(null);
		comrepo.deleteById(complaint_id);
		return "Deleted";
	}



	public List<Complaint> findingByStatusSorted(String complaint_status) {
		// TODO Auto-generated method stub
		
		List<Complaint> le=comrepo.findByStatusSorted(complaint_status);
		comrepo.saveAll(le);
		return le;
	}
	public boolean getComplaintExistById(int complaint_id) {
		return comrepo.existsById(complaint_id);
	}
	
	
}