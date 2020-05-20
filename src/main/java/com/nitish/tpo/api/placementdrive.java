package com.nitish.tpo.api;

    
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "placementdrive")
public class placementdrive {
	@Id
	@Column(name="id")
	int id;
	@Column(name="name")
    String name;
	@Column(name="profile")
    String profile;
	@Column(name="package")
    int score;
	@Column(name="bond")
    int backlog;
	@Column(name="date")
	Date date;
	@Column(name="email")
	String email;
	@Column(name="description")
	String description;
	
	public placementdrive()
	{
		
	}
	
	public placementdrive(int id, String name, String profile, int score, int backlog, Date date, String email,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.profile = profile;
		this.score = score;
		this.backlog = backlog;
		this.date = date;
		this.email = email;
		this.description = description;
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
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
		
}
