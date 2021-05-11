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
public class Product {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="product_generations")

	@SequenceGenerator(name="product_generations", sequenceName = "product_sequences", allocationSize=1)
	private int product_id;
	
	@NotEmpty(message = "please enter product name")
	private String product_name;
	private int price;
	private int quantity;
	private String product_status;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "prodd")
	private Supplier1 sup;
	@JsonManagedReference
	public Supplier1 getSup() {
		return sup;
	}
	public void setSup(Supplier1 sup) {
		this.sup = sup;
	}
	@ManyToOne
	private Farmer farm;
	
	@JsonBackReference
	public Farmer getFarm() {
		return farm;
	}
	public void setFarm(Farmer farm) {
		this.farm = farm;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getProduct_status() {
		return product_status;
	}
	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
				+ ", quantity=" + quantity + ", product_status=" + product_status + "]";
	}
	
	
	

}

