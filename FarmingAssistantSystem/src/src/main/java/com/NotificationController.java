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

import com.model.Notification;
import com.service.NotificationService;
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
@Validated
public class NotificationController {
	
	@Autowired
	NotificationService nservice;
	
	@GetMapping(path ="/getNotification")
	public ResponseEntity<List<Notification>> getNotification()
	{
        List<Notification> le=nservice.getNoti();
		
		ResponseEntity<List<Notification>>  re=new ResponseEntity<List<Notification>>(le,HttpStatus.OK);
		return re;
		
	}
	@GetMapping(path="/getNotifications/{notification_id}")
	public ResponseEntity<Notification> getNotiById(@PathVariable int notification_id) throws Exception
	{
		Notification e1=nservice.getNotiById(notification_id);
		
		ResponseEntity re=new ResponseEntity<Notification>(e1,HttpStatus.OK);
		return re;
	}
	
	
	
	@PostMapping(path="/addNotification")
	public ResponseEntity<Notification> addNotification(@Valid @RequestBody Notification c)
	{
		Notification c1=nservice.createNotification(c);
		
		ResponseEntity re=new ResponseEntity<Notification>(c1,HttpStatus.OK);
		return re;
	}
	@PostMapping(path="/addNotifications")
	public ResponseEntity<List<Notification>> addNotification(@Valid @RequestBody List<Notification> ls)
	{
		
		List<Notification> le=nservice.addComp(ls);
		ResponseEntity re=new ResponseEntity<List<Notification>>(le,HttpStatus.OK);
		return re;
		
	}
	
	@PutMapping(path="/updateNotification")
	public ResponseEntity<Notification> updateNotification(@RequestBody Notification c) throws Exception
	{
		Notification c1=nservice.updateNoti(c);
		ResponseEntity re =new ResponseEntity<Notification>(c1,HttpStatus.OK);
		return re;
	}
		@DeleteMapping(path="/deleteNotification")
		public ResponseEntity<Notification> deleteNotification(@RequestBody int notification_id)
		{
			Notification c1=nservice.deleteNoti(notification_id);
	
			ResponseEntity re=new ResponseEntity<Notification>( c1,HttpStatus.OK);
			
			return re;
			
		}
		@DeleteMapping(path="/deleteNotifications/{notification_id}")
		public ResponseEntity<String> deleteEmployeeById(@PathVariable int notification_id)
		{
			nservice.deleteNotiById(notification_id);
			ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
			return re;
			
		}

}
