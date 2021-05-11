package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.NotificationNotFoundException;
import com.model.Notification;
import com.repository.NotificationRepository;

@Service
public class NotificationService {

	List<Notification> ne;
	
	@Autowired
	NotificationRepository notrepo;
	
	public Notification createNotification(Notification n)
	{
		Notification n1 = notrepo.save(n);
		return n1;
	}
	public List<Notification> getNoti(){
		ne = new ArrayList();
		ne = notrepo.findAll();
		return ne;
	}
	
	public Notification getNotiById(int notification_id) throws Exception{
		Supplier<Exception> s2 = ()-> new NotificationNotFoundException("notification id not found");
		Notification n1 = notrepo.findById(notification_id).orElseThrow(s2);
		return n1;
	}
	public List<Notification> addComp(List<Notification> ls) {
		// TODO Auto-generated method stub
		ne = new ArrayList<>();
		ne = notrepo.saveAll(ls);
		return ne;
	}

	public Notification updateNoti(Notification n) throws Exception {
		// TODO Auto-generated method stub
		int id = n.getNotification_id();
		Supplier<Exception> s1 = ()->new NotificationNotFoundException("Complaint id is not present in the database");
		Notification c1=notrepo.findById(id).orElseThrow(s1);
		c1.setNotification_name(n.getNotification_name());

	
		notrepo.save(c1);
		return c1;	
		}
	public Notification deleteNoti(int notification_id ) {
		Notification c1 = notrepo.findById(notification_id).orElse(null);
		notrepo.deleteById(notification_id);
		
		return c1;
		
		
	}

	public String deleteNotiById(int notification_id) {
		// TODO Auto-generated method stub
		Notification c1 = notrepo.findById(notification_id).orElse(null);
		notrepo.deleteById(notification_id);
		return "Deleted";
	}

	
	
}
