package com.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class AdminModule {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="adminmodule_generations")
	@SequenceGenerator(name="adminmodule_generations", sequenceName = "adminmodule_sequences", allocationSize=1)
	private int id;
	
	@ManyToOne
	private Complaint com;
	
	@JsonBackReference
	public Complaint getCom() {
		return com;
	}
	public void setCom(Complaint com) {
		this.com = com;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Admintable [id=" + id + ", com=" + com + "]";
	}
	
	

}
