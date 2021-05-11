//package com;
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.model.Complaint;
//import com.model.Farmer;
//import com.model.Notification;
//import com.service.FarmerService;
//import com.service.NotificationService;
//
//@RestController
//@CrossOrigin(origins="http://localhost:4200")
//@RequestMapping("/api")
//@Validated
//public class FarmerController {
//	
//    @Autowired
//    FarmerService fservice;
//    @Autowired
//	NotificationService nservice;
//
//	
//	@GetMapping(path="/getFarmers")
//	public ResponseEntity <List<Farmer>> getFarmers() 
//	{
//		List<Farmer> le= fservice.getFarmers();
//		ResponseEntity re=new ResponseEntity <List<Farmer>>(le,HttpStatus.OK);
//		return re;
//	}
//	
//	@GetMapping(path="/getFarmerById/{id}") 
//	public ResponseEntity <Farmer> getFarmerBy(@PathVariable int id) throws Exception
//	{
//		Farmer le= fservice.getFarmerById(id);
//		ResponseEntity re=new ResponseEntity <Farmer>(le,HttpStatus.OK);
//		return re;
//	}
//	
//	@PostMapping(path="/addFarmer")
//	public ResponseEntity <Farmer> addFarmer(@Valid @RequestBody Farmer ls )
//	{
//		Farmer f1=fservice.addFarmer(ls);
//		ResponseEntity re=new ResponseEntity <Farmer> (f1,HttpStatus.OK);
//		return re;
//	}
//	
//	@PostMapping(path="/addFarmers")
//	public ResponseEntity <List<Farmer>> addFarmers(@Valid @RequestBody List<Farmer> ls )
//	{
//		List<Farmer> le=fservice.addFarmers(ls);
//		ResponseEntity re=new ResponseEntity <List<Farmer>> (le,HttpStatus.OK);
//		return re;
//	}
//	
//	@PutMapping(path="/updateFarmer")
//	public ResponseEntity <Farmer> updateFarmer(@RequestBody Farmer up) throws Exception
//	{
//		Farmer f2=fservice.updateFarmer(up);
//		ResponseEntity re=new ResponseEntity <Farmer> (f2,HttpStatus.OK);
//		return re;
//	}
//		
//	
//	@DeleteMapping(path="/deleteFarmer")
//	public ResponseEntity<Farmer> deleteEmployee(@RequestBody int Farmerid)
//	{
//		Farmer f2=fservice.deleteFarmer(Farmerid);
//		
//		ResponseEntity re=new ResponseEntity<Farmer>(f2,HttpStatus.OK);
//		return re;
//	}
//	
//	@DeleteMapping(path="/deleteFarmerById/{Farmerid}")
//	public ResponseEntity<String> deleteFarmerById (@PathVariable int Farmerid)
//	{
//		fservice.deleteFarmerById(Farmerid);
//		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
//		return re;
//	}
//	
//	//get Notification
//	
//		@GetMapping(path ="/getNotificationByFarmer")
//		public ResponseEntity<List<Notification>> getNotification()
//		{
//	        List<Notification> le=fservice.getNoti();
//			
//			ResponseEntity<List<Notification>>  re=new ResponseEntity<List<Notification>>(le,HttpStatus.OK);
//			return re;
//			
//		}
// 
//		@GetMapping(path="/getFarmerByfirst_name/{first_name}")
//		  public ResponseEntity<List<Farmer>> findingByfirst_name(@PathVariable String first_name)
//		  { 
//			  List<Farmer> l1=fservice.findByfirst_name(first_name);
//		  
//		  ResponseEntity re=new ResponseEntity<List<Farmer>>(l1,HttpStatus.OK); 
//		  return re;
//		  }
//
//}


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
import com.model.Farmer;
import com.model.Notification;
import com.service.FarmerService;
import com.service.NotificationService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
@Validated
public class FarmerController {
@Autowired
FarmerService fservice;
@Autowired
NotificationService nservice;

@GetMapping(path="/getFarmers")
public ResponseEntity <List<Farmer>> getFarmers()
{
List<Farmer> le= fservice.getFarmers();
ResponseEntity re=new ResponseEntity <List<Farmer>>(le,HttpStatus.OK);
return re;
}
@GetMapping(path="/getFarmerById/{id}")
public ResponseEntity <Farmer> getFarmerBy(@PathVariable int id) throws Exception
{
Farmer le= fservice.getFarmerById(id);
ResponseEntity re=new ResponseEntity <Farmer>(le,HttpStatus.OK);
return re;
}
@PostMapping(path="/addFarmer")
public ResponseEntity <Farmer> addFarmer(@Valid @RequestBody Farmer ls )
{
Farmer f1=fservice.addFarmer(ls);
ResponseEntity re=new ResponseEntity <Farmer> (f1,HttpStatus.OK);
return re;
}
@PostMapping(path="/addFarmers")
public ResponseEntity <List<Farmer>> addFarmers(@Valid @RequestBody List<Farmer> ls )
{
List<Farmer> le=fservice.addFarmers(ls);
ResponseEntity re=new ResponseEntity <List<Farmer>> (le,HttpStatus.OK);
return re;
}
@PutMapping(path="/updateFarmer")
public ResponseEntity <Farmer> updateFarmer(@RequestBody Farmer up) throws Exception
{
Farmer f2=fservice.updateFarmer(up);
ResponseEntity re=new ResponseEntity <Farmer> (f2,HttpStatus.OK);
return re;
}

@DeleteMapping(path="/deleteFarmer")
public ResponseEntity<Farmer> deleteEmployee(@RequestBody int Farmerid)
{
Farmer f2=fservice.deleteFarmer(Farmerid);
ResponseEntity re=new ResponseEntity<Farmer>(f2,HttpStatus.OK);
return re;
}
@DeleteMapping(path="/deleteFarmerById/{Farmerid}")
public ResponseEntity<String> deleteFarmerById (@PathVariable int Farmerid)
{
fservice.deleteFarmerById(Farmerid);
ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
return re;
}
//get Notification
@GetMapping(path ="/getNotificationByFarmer")
public ResponseEntity<List<Notification>> getNotification()
{
List<Notification> le=fservice.getNoti();
ResponseEntity<List<Notification>> re=new ResponseEntity<List<Notification>>(le,HttpStatus.OK);
return re;
}
@GetMapping(path="/getFarmerByfirst_name/{first_name}")
public ResponseEntity<List<Farmer>> findingByfirst_name(@PathVariable String first_name)
{
List<Farmer> l1=fservice.findByfirst_name(first_name);
ResponseEntity re=new ResponseEntity<List<Farmer>>(l1,HttpStatus.OK);
return re;
}

}