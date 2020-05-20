package com.nitish.tpo.api;



import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driveregistration")
public class driveregistration {
	@Id
	@Column(name="regid")
    String id;
	@Column(name="driveid")
    String driveid;
	@Column(name="studentid")
    String studentid;
	
	public driveregistration()
	{
		
	}
	
	public driveregistration( String driveid, String studentid) {
	
		this.id = UUID.randomUUID().toString().substring(0,23);
		this.driveid = driveid;
		this.studentid = studentid;
	}
	public String getId(){
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDriveid() {
		return driveid;
	}
	public void setDriveid(String driveid) {
		this.driveid = driveid;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

}
