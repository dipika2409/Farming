package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Supplier1{
	@Id	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="supplier_generations")

	@SequenceGenerator(name="supplier_generations", sequenceName = "supplier_sequences", allocationSize=1)
	private int supplier_id;
	
	@NotEmpty
	private String name;
	private String  email;
	private String mobile_no;
	private String product_status;
	

	@OneToOne(cascade = CascadeType.ALL,mappedBy = "supp")
	private Advertise adver;
	@JsonManagedReference
	public Advertise getAdver() {
		return adver;
	}

	public void setAdver(Advertise adver) {
		this.adver = adver;
	}
	@OneToOne
	private Product prodd;
	
	@JsonBackReference
	public Product getProdd() {
		return prodd;
	}

	public void setProdd(Product prodd) {
		this.prodd = prodd;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getProduct_status() {
		return product_status;
	}
	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}
	@Override
	public String toString() {
		return "Supplier1 [supplier_id=" + supplier_id + ", name=" + name + ", email=" + email + ", mobile_no="
				+ mobile_no + ", product_status=" + product_status + ", prodd=" + prodd + "]";
	}
	
}
	
	
	
	
	
	
	

