package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Advertise {


	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="advertise_generations")

	@SequenceGenerator(name="advertise_generations", sequenceName = "advertise_sequences", allocationSize=1)
	private int adv_id;
	@NotEmpty(message = "Advertisement should be entered")
	@Size(min = 3,max = 100)
	private String adv_title;
	@NotEmpty
	private String adv_description;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "adv")
	private List<Notification> noti;
	
	
	@OneToOne
	private Supplier1 supp;
	@JsonManagedReference
	public List<Notification> getNoti() {
		return noti;
	}
	public void setNoti(List<Notification> noti) {
		this.noti = noti;
	}
	@JsonBackReference
	public Supplier1 getSupp() {
		return supp;
	}
	public void setSupp(Supplier1 supp) {
		this.supp = supp;
	}
	public int getAdv_id() {
		return adv_id;
	}
	public void setAdv_id(int adv_id) {
		this.adv_id = adv_id;
	}
	public String getAdv_title() {
		return adv_title;
	}
	public void setAdv_title(String adv_title) {
		this.adv_title = adv_title;
	}
	public String getAdv_description() {
		return adv_description;
	}
	public void setAdv_description(String adv_description) {
		this.adv_description = adv_description;
	}
	@Override
	public String toString() {
		return "Advertise [adv_id=" + adv_id + ", adv_title=" + adv_title + ", adv_description=" + adv_description
				+ "]";
	}
	
	
}
