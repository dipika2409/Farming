package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Notification {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="notification_generations")

	@SequenceGenerator(name="notification_generations", sequenceName = "notification_sequences", allocationSize=1)
	private int notification_id;
	@NotEmpty
	private String notification_name;
	@ManyToOne
	private Advertise adv;
	@JsonBackReference
	public Advertise getAdv() {
		return adv;
	}
	public void setAdv(Advertise adv) {
		this.adv = adv;
	}
	public int getNotification_id() {
		return notification_id;
	}
	public void setNotification_id(int notification_id) {
		this.notification_id = notification_id;
	}
	public String getNotification_name() {
		return notification_name;
	}
	public void setNotification_name(String notification_name) {
		this.notification_name = notification_name;
	}
	@Override
	public String toString() {
		return "Notification [notification_id=" + notification_id + ", notification_name=" + notification_name + "]";
	}
	
	
	
	

}