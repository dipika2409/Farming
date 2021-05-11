package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.AdvertiseNotFoundException;
import com.advices.ComplaintNotFoundException;
import com.model.Advertise;
import com.model.Complaint;
import com.repository.AdvertiseRepository;


@Service
public class AdvertiseService {
	
  List<Advertise> le;
	
	@Autowired(required = true)
	AdvertiseRepository advrepo;
	

	public List<Advertise> getAdvertise() {

		le=new ArrayList();
		le=advrepo.findAll(); 
		return le;	
	}

	public Advertise getAdvById(int adv_id) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s2=()-> new AdvertiseNotFoundException ("Advertise is not present in the database");
		Advertise c1 = advrepo.findById(adv_id).orElseThrow(s2);
		return c1;
	}


	public Advertise createAdvertise(Advertise c) {
		// TODO Auto-generated method stub
		Advertise c1=advrepo.save(c);
		
		return c1;
	}


	public List<Advertise> addAdver(List<Advertise> ls) {
		// TODO Auto-generated method stub
		le = new ArrayList<>();
		le = advrepo.saveAll(ls);
		return le;
	}


	public Advertise updateAdv(Advertise c) throws Exception {
		// TODO Auto-generated method stub
		int id = c.getAdv_id();
		Supplier<Exception> s1 = ()->new AdvertiseNotFoundException("Advertise id is not present in the database");
		Advertise c1=advrepo.findById(id).orElseThrow(s1);
		c1.setAdv_title(c.getAdv_title());
		c1.setAdv_description(c.getAdv_description());
		
		advrepo.save(c1);
		return c1;	
	}


	public  Advertise deleteAdv(int  advertise_id ) {
		 Advertise c1=advrepo.findById(advertise_id).orElse(null);
				advrepo.deleteById(advertise_id);
				return c1;	
		
	}


	public String deleteAdvById(int adv_id) {
		// TODO Auto-generated method stub
		Advertise c1 = advrepo.findById(adv_id).orElse(null);
		advrepo.deleteById(adv_id);
		return "Deleted";
		
	}
}
