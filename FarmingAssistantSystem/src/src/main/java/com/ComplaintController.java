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

import com.model.Complaint;
import com.service.ComplaintService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
@Validated
public class ComplaintController {

	@Autowired
	ComplaintService cservice;
	
	
	@GetMapping(path="/getComplaint")
	public ResponseEntity<List<Complaint>> getComplaint()
	{
         List<Complaint> le=cservice.getComp();
		
		ResponseEntity re=new ResponseEntity<List<Complaint>>(le,HttpStatus.OK);
		return re;
		
	}
	@GetMapping(path="/getComplaints/{complaint_id}")
	public ResponseEntity<Complaint> getComById(@PathVariable int complaint_id) throws Exception
	{
		Complaint e1=cservice.getComById(complaint_id);
		
		ResponseEntity re=new ResponseEntity<Complaint>(e1,HttpStatus.OK);
		return re;
	}
	
	 @GetMapping(path="/getComplaintSort/{complaint_status}")
	  public ResponseEntity<List<Complaint>> findingByStatusSorted(@PathVariable String complaint_status)
	  { 
		  List<Complaint> l1=cservice.findingByStatusSorted(complaint_status);
	  
	  ResponseEntity re=new ResponseEntity<List<Complaint>>(l1,HttpStatus.OK); 
	  return re;
	  }
	
	@PostMapping(path="/addComplaint")
	public ResponseEntity<Complaint> addComplaint(@Valid @RequestBody Complaint c)
	{
		Complaint c1=cservice.createComplaint(c);
		
		ResponseEntity re=new ResponseEntity<Complaint>(c1,HttpStatus.OK);
		return re;
	}
	@PostMapping(path="/addComplaints")
	public ResponseEntity<List<Complaint>> addComplaints(@Valid @RequestBody List<Complaint> ls)
	{
		
		List<Complaint> le=cservice.addComp(ls);
		ResponseEntity re=new ResponseEntity<List<Complaint>>(le,HttpStatus.OK);
		return re;
		
	}
	
	@PutMapping(path="/updateComplaint")
	public ResponseEntity<Complaint> updateComplaint(@RequestBody Complaint c) throws Exception
	{
		Complaint c1=cservice.updateComp(c);
		ResponseEntity re =new ResponseEntity<Complaint>(c1,HttpStatus.OK);
		return re;
	}
	@DeleteMapping(path="/deleteComplaint")
	public ResponseEntity<Complaint> deleteComplaint(@RequestBody int complaint_id)
	{
		Complaint c1=cservice.deleteComp(complaint_id);
		ResponseEntity re=new ResponseEntity<Complaint>(c1,HttpStatus.OK);
		
		return re;
		
	}
		@DeleteMapping(path="/deleteComplaints/{complaint_id}")
		public ResponseEntity<String> deleteEmployeeById(@PathVariable int complaint_id)
		{
			cservice.deleteCompById(complaint_id);
			ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
			return re;
			
		}
	}