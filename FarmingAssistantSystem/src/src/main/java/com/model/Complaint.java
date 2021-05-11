//package com.model;
//
//import java.util.List;
//import java.util.function.IntPredicate;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//@Entity
//public class Complaint {
//	
//	@Id
//	//@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="complaint_generations")
//
//	@SequenceGenerator(name="complaint_generations", sequenceName = "complaint_sequences", allocationSize=1)
//	private int complaint_id;
//	
//	@NotEmpty(message = "Complaint should be entered")
//	@Size(min = 3, max = 100)
//	private String complaint_text;
//	
//	private String complaint_status;
//	
//	@NotEmpty(message = "Complaint should be entered")
//	private String complaint_type;
//	
//	@ManyToOne
//	private Farmer far;
//	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "com")
//	private List<AdminModule> admint;
//	
//	
//	
//	@JsonManagedReference
//	public List<AdminModule> getAdmint() {
//		return admint;
//	}
//	public void setAdmint(List<AdminModule> admint) {
//		this.admint = admint;
//	}
//	
//	@JsonIgnore
//	@JsonBackReference
//	public Farmer getFar() {
//		return far;
//	}
//	@JsonIgnore
//	public void setFar(Farmer far) {
//		this.far = far;
//	}
//	public int getComplaint_id() {
//		return complaint_id;
//	}
//	public void setComplaint_id(int complaint_id) {
//		this.complaint_id = complaint_id;
//	}
//	public String getComplaint_text() {
//		return complaint_text;
//	}
//	public void setComplaint_text(String complaint_text) {
//		this.complaint_text = complaint_text;
//	}
//	public String getComplaint_status() {
//		return complaint_status;
//	}
//	public void setComplaint_status(String complaint_status) {
//		this.complaint_status = complaint_status;
//	}
//	
//	
//	
//	
//	public String getComplaint_type() {
//		return complaint_type;
//	}
//	public void setComplaint_type(String complaint_type) {
//		this.complaint_type = complaint_type;
//	}
//	@Override
//	public String toString() {
//		return "Complaint [complaint_id=" + complaint_id + ", complaint_text=" + complaint_text + ", complaint_status="
//				+ complaint_status + ", complaint_type=" + complaint_type + ", far=" + far + ", admint=" + admint + "]";
//	}
//	
//
//}

package com.model;

import java.util.List;
import java.util.function.IntPredicate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Complaint {
@Id
/* @GeneratedValue(strategy = GenerationType.AUTO) */
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="complaint_generations")
@SequenceGenerator(name="complaint_generations", sequenceName = "complaint_sequences", allocationSize=1)
private int complaint_id;
@NotEmpty(message = "Complaint should be entered")
private String complaint_type;
@NotEmpty(message = "Complaint should be entered")
@Size(min = 3, max = 100)
private String complaint_text;
private String complaint_status;

@JsonIgnore
@ManyToOne
//@JoinColumn(name="farmer id")
private Farmer far;

 @OneToMany(cascade = CascadeType.ALL,mappedBy = "com")
private List<AdminModule> admint;
@JsonManagedReference
public List<AdminModule> getAdmint() {
return admint;
}
public void setAdmint(List<AdminModule> admint) {
this.admint = admint;
}
@JsonBackReference
public Farmer getFar() {
return far;
}
public void setFar(Farmer far) {
this.far = far;
}
public int getComplaint_id() {
return complaint_id;
}
public void setComplaint_id(int complaint_id) {
this.complaint_id = complaint_id;
}
public String getComplaint_type() {
return complaint_type;
}
public void setComplaint_type(String complaint_type) {
this.complaint_type = complaint_type;
}
public String getComplaint_text() {
return complaint_text;
}
public void setComplaint_text(String complaint_text) {
this.complaint_text = complaint_text;
}
public String getComplaint_status() {
return complaint_status;
}
public void setComplaint_status(String complaint_status) {
this.complaint_status = complaint_status;
}

@Override
public String toString() {
return "Complaint [complaint_id=" + complaint_id + ", complaint_type=" + complaint_type + ", complaint_text="
+ complaint_text + ", complaint_status=" + complaint_status + ", far=" + far + ", admint=" + admint
+ "]";
}


}
