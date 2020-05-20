package com.nitish.tpo.api;


import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studentprofile")
public class studentProfile {
	@Id
	@Column(name="id")
	int id;
	@Column(name="name")
    String name;
	@Column(name="branch")
    String branch;
	@Column(name="score")
    int score;
	@Column(name="backlog")
    int backlog;
	@Column(name="year")
	String year;
	@Column(name="phone")
	BigInteger phone;
	@Column(name="email")
	String email;
	
	public studentProfile()
	{
		
	}
	
	public studentProfile(int id, String name, String branch, int score, int backlog, String year, BigInteger phone, String email) 
	{
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.score = score;
		this.backlog = backlog;
		this.year = year;
		this.phone = phone;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getBacklog() {
		return backlog;
	}
	public void setBacklog(int backlog) {
		this.backlog = backlog;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public BigInteger getPhone() {
		return phone;
	}
	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
