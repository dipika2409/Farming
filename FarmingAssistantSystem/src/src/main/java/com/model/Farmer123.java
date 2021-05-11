package com.model;

import org.springframework.beans.factory.annotation.Value;
	import org.springframework.stereotype.Component;
	
	@Component("far")
	public class Farmer123 {
		
		@Value("${farmer_id}")
		private int farmer_id;
		
		@Value("${first_name}")
		private String first_name;
		
		@Value("${last_name}")
		private String last_name;
		
		@Value("${gender}")
		private String gender;
		
		@Value("${contact_number}")
		private String contact_number;

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
			return "Farmer123 [farmer_id=" + farmer_id + ", first_name=" + first_name + ", last_name=" + last_name
					+ ", gender=" + gender + ", contact_number=" + contact_number + "]";
		}

		
		
	}

