package com.model;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity

public class User1 {
	 @Id
	 //@GeneratedValue(strategy=GenerationType.AUTO)  
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="User1_generations")

	 @SequenceGenerator(name="User1_generations", sequenceName = "User1_sequences", allocationSize=1)
	    private int uId;
	    //emailId should be a valid email format
	    //emailId should not be null or empty
		
		  @NotEmpty
		  
		  @Email
		 
	 	@JoinColumn
	    private String emailId;
	    //userName should not be null or empty
	    //userName should have atleast 3 characters
		
		 @NotEmpty(message = "username should be field")
		  
		  //@Size(min=3,message="userName should have atleast 3 characters")
		 
	 	
	    private String userName;
	    //password should not be null or empty
	    //password should have atleast 8 characters
		
		  @NotEmpty
		  
		  @Size(min=8,message="password should have atleast 8 characters")
		 
	    private  String password;
		public int getuId() {
			return uId;
		}
		public void setuId(int uId) {
			this.uId = uId;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "User1 [uId=" + uId + ", emailId=" + emailId + ", userName=" + userName + ", password=" + password
					+ "]";
		}
		

}
