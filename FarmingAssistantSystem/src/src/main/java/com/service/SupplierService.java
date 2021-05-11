package com.service;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.SupplierNotFoundException;
import com.model.Supplier1;

import com.repository.SupplierRepository;

@Service
public class SupplierService {
	
	List<Supplier1> le;
	
	@Autowired(required=true)
	SupplierRepository erepo;
	
	public List<Supplier1> getSuppliers()
	{
		le=new ArrayList<>();
		le=erepo.findAll();
		return le;
	}
	
		
	public Supplier1 createSupplier(Supplier1 e)
	{
		Supplier1 e1=erepo.save(e);
		return e1;
	}
	public List<Supplier1> addSuppliers(List<Supplier1> ls) {
		le=new ArrayList<>();
		le=erepo.saveAll(ls);
		return le;
	}

	public Supplier1 updateSupplier(Supplier1 p)throws Exception {
		// TODO Auto-generated method stub
		int id = p.getSupplier_id();
		Supplier<Exception> s1 = ()->new SupplierNotFoundException("Supplier id is not present in the database");
		
		Supplier1 p1=erepo.findById(id).orElseThrow();
		p1.setName(p.getName());
	
		erepo.save(p1);
		return p1;	
		}
	   public Supplier1 deleteSupplier(int id) {
		Supplier1 e=erepo.findById(id).orElse(null);
		erepo.deleteById(id);
		return e;
	}
	public String deleteSupplierById(int id) {
		Supplier1 e=erepo.findById(id).orElse(null);
		erepo.deleteById(id);
		return "Deleted";
	}

}
