package com;

import java.util.List;
import javax.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Advertise;
import com.model.Complaint;
import com.service.AdvertiseService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
@Validated
public class AdvertiseController {
	
	@Autowired
	AdvertiseService advservice;
	
	
	@GetMapping(path="/getAdvertise")
	public ResponseEntity<List<Advertise>> getAdvertise()
	{
         List<Advertise> le=advservice.getAdvertise();
		 
		ResponseEntity re=new ResponseEntity<List<Advertise>>(le,HttpStatus.OK);
		return re;
		
	}
	
	@GetMapping(path="/getAdvertises/{adv_id}") 
	public ResponseEntity<Advertise> getAdvById(@PathVariable int adv_id) throws Exception
	{
		Advertise e1=advservice.getAdvById(adv_id);
		
		ResponseEntity re=new ResponseEntity<Advertise>(e1,HttpStatus.OK);
		return re;
	}

	@PostMapping(path="/addAdvertise")
	public ResponseEntity<Advertise> addAdvertise(@Valid @RequestBody Advertise c)
	{
		Advertise c1=advservice.createAdvertise(c);
		
		ResponseEntity re=new ResponseEntity<Advertise>(c1,HttpStatus.OK);
		return re;
		
	}
	
	@PostMapping(path="/addAdvertisement")
	public ResponseEntity<List<Advertise>> addAdvertisement(@Valid @RequestBody List<Advertise> ls)
	{
		
		List<Advertise> le=advservice.addAdver(ls);
		ResponseEntity re=new ResponseEntity<List<Advertise>>(le,HttpStatus.OK);
		return re;
		
	}
	
	@PutMapping(path="/updateAdvertise")
	public ResponseEntity<Advertise> updateAdvertise(@RequestBody Advertise c) throws Exception
	{
		Advertise c1=advservice.updateAdv(c);
		ResponseEntity re =new ResponseEntity<Advertise>(c1,HttpStatus.OK);
		return re;
	}

	@DeleteMapping(path="/deleteAdvertise")
	public ResponseEntity<Complaint> deleteAdvertise(@RequestBody int advertise_id)
	{
		Advertise c1=advservice.deleteAdv(advertise_id);
		ResponseEntity re=new ResponseEntity<Advertise>(c1,HttpStatus.OK);
		
		return re;
		
	}
	@DeleteMapping(path="/deleteAdvertisement/{adv_id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int adv_id)
	{
		advservice.deleteAdvById(adv_id);
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
		
	}
	
	
}