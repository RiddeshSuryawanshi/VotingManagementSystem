package com.example.votingSystem.com.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Voter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	@NotBlank(message = "Name Cannot be blank")
	@Pattern(regexp = "^a-zA-Z+$",message = "Only Characters are allowed")
    private String voterName;
    private Date DOB;
    private String gender;
    private String username;
    private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVoterName() {
		return voterName;
	}
	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Voter(int id,
			@NotBlank(message = "Name Cannot be blank") @Pattern(regexp = "^a-zA-Z+$", message = "Only Characters are allowed") String voterName,
			Date dOB, String gender, String username, String password) {
		super();
		this.id = id;
		this.voterName = voterName;
		DOB = dOB;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}
	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Voter [id=" + id + ", voterName=" + voterName + ", DOB=" + DOB + ", gender=" + gender + ", username="
				+ username + ", password=" + password + "]";
	}
    
    
    
    
}
