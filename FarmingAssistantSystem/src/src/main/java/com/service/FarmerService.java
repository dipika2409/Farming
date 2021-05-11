package com.service;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.FarmerNotFoundException;
import com.model.Complaint;
import com.model.Farmer;
import com.model.Notification;
import com.repository.FarmerRepository;
import com.repository.NotificationRepository;


@Service
public class FarmerService {
	
	List<Farmer> le;
List<Notification> ne;
	
	@Autowired
	NotificationRepository notrepo;
	
	@Autowired
	FarmerRepository farrepo;
	
	public List<Farmer> getFarmers() 
	{
		
		le=new ArrayList();
		le=farrepo.findAll(); 
		return le;
		
	}	
	
	public Farmer getFarmerById(int id) throws Exception {
		Supplier<Exception> s2=()-> new FarmerNotFoundException ("Farmer id is not present in the database");
		Farmer f1= farrepo.findById(id).orElseThrow(s2);
		 return f1;
						
	}
	
	public Farmer addFarmer(Farmer ls)
	{
		Farmer f1=farrepo.save(ls);
		return f1;
		
	}
		
	public List<Farmer> addFarmers(List<Farmer> ls)
	{
		le=new ArrayList<>();
		le=farrepo.saveAll(ls);
		return le;
	}
	
	public Farmer updateFarmer(Farmer up) throws Exception
	{
		int id=up.getFarmer_id();
		Supplier<Exception> s1=()-> new FarmerNotFoundException ("Farmer id is not present in the database");
		Farmer f1=farrepo.findById(id).orElseThrow(s1);
		Farmer farmer=new Farmer();
		farmer.setFirst_name(up.getFirst_name());
		farmer.setContact_number(up.getContact_number());
		farmer.setFarmer_id(up.getFarmer_id());
		farmer.setLast_name(up.getLast_name());
		farmer.setGender(up.getGender());

		return farrepo.save(farmer);
		
	}
	
	public Farmer deleteFarmer(int Farmerid)
	{
		Farmer f1=farrepo.findById(Farmerid).orElse(null);
		farrepo.deleteById(Farmerid);
		return f1;
	}
	
	public String deleteFarmerById(int Farmerid) {
		
		Farmer s=farrepo.findById(Farmerid).orElse(null);
		farrepo.deleteById(Farmerid);
		return "Deleted";
	}

	public List<Notification> getNoti(){
		ne = new ArrayList();
		ne = notrepo.findAll();
		return ne;
	}
	
	public List<Farmer> findByfirst_name(String first_name) {
		List<Farmer> le=farrepo.findByfirst_name(first_name);
		farrepo.saveAll(le);
		return le;
	}
	
	public List<Farmer> findByfirst_name1(String first_name) {
		List<Farmer> le=farrepo.findByfirst_name(first_name);
		farrepo.saveAll(le);
		return le;
	}


	
}