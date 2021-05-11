package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Farmer {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="farmer_generations")
	@SequenceGenerator(name="farmer_generations", sequenceName = "farmer_sequences", allocationSize=1)
	private int farmer_id;
	
	@NotEmpty
	private String first_name;
	@NotEmpty
	private String last_name;
	private String gender;
	@NotEmpty(message = "please enter mobile number")
	@Size(min = 10,max = 10, message = "mobile number is not valid")
	private String contact_number;
	
	//for farmer to complaint---@OneToMany
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "far")
	//@JoinColumn(name="cf_fk", referencedColumnName="farmer_id")
	private List<Complaint> complaints;
	
	//for farmer to product--@OneToMany
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "farm")
	private List<Product> prod;
	
	@JsonManagedReference
	public List<Product> getProd() {
		return prod;
	}
	public void setProd(List<Product> prod) {
		this.prod = prod;
	}
	@JsonManagedReference
	public List<Complaint> getComplaints() {
		return complaints;
	}
	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}
	public int getFarmer_id() {
		return farmer_id;
	}
	public void setFarmer_id(int farmer_id) {
		this.farmer_id = farmer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	@Override
	public String toString() {
		return "Farmer [farmer_id=" + farmer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", gender=" + gender + ", contact_number=" + contact_number + ", complaints=" + complaints + "]";
	}
	
	
	
	
	
	
	
}