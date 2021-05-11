package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.AdminModule;
import com.model.Complaint;
import com.model.Farmer;
import com.model.Notification;
import com.service.AdminService;
import com.service.ComplaintService;
import com.service.FarmerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class AdminController {

		@Autowired
		AdminService aservice;
	
		@Autowired
	    FarmerService fservice;
		
		@Autowired
		ComplaintService cservice;
		
		
	    @GetMapping(path="/getFarmersDetails")
	    public ResponseEntity <List<Farmer>> getFarmers()
	    {
	        List<Farmer> le= aservice.getFarmers();
	        ResponseEntity re=new ResponseEntity <List<Farmer>>(le,HttpStatus.OK);
	        return re;
	    }
	    
	    
	  //getComplaint
	    @GetMapping(path="/getComplaintByAdmin")
	    public ResponseEntity<List<Complaint>> getComplaint()
	    {
	         List<Complaint> le=aservice.getComp();
	        
	        ResponseEntity re=new ResponseEntity<List<Complaint>>(le,HttpStatus.OK);
	        return re;
	        
	    }
	
		//updating complain status(done by admin)
		
		@PutMapping(path="/updateComplaintByAdmin")
		public ResponseEntity<Complaint> updateComplaintByAdmin(@RequestBody Complaint c) throws Exception
		{
			Complaint c1=aservice.updateComp(c);
			ResponseEntity re =new ResponseEntity<Complaint>(c1,HttpStatus.OK);
			return re;
		}
		
		@GetMapping(path ="/getNotificationByAdmin")
		public ResponseEntity<List<Notification>> getNotification()
		{
	        List<Notification> le=aservice.getNoti();
			
			ResponseEntity<List<Notification>>  re=new ResponseEntity<List<Notification>>(le,HttpStatus.OK);
			return re;
			
		}
		@GetMapping(path="/getAdminDetails")
		public ResponseEntity <List<AdminModule>> getAdminDetails()
		{
		List<AdminModule> le= aservice.getAdminDetail();
		ResponseEntity re=new ResponseEntity <List<AdminModule>>(le,HttpStatus.OK);
		return re;
		}
		
		
		
	
}
