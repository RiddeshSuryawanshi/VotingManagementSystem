package com.example.votingSystem.com.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Election {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String etitle;
	private String description;
	private Date startDate;
	private Date endDate;
	private String e_type;
	private String status;
	@Override
	public String toString() {
		return "Election [eid=" + eid + ", etitle=" + etitle + ", description=" + description + ", startDate="
				+ startDate + ", endDate=" + endDate + ", e_type=" + e_type + ", status=" + status + "]";
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEtitle() {
		return etitle;
	}
	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getE_type() {
		return e_type;
	}
	public void setE_type(String e_type) {
		this.e_type = e_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Election() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Election(int eid, String etitle, String description, Date startDate, Date endDate, String e_type,
			String status) {
		super();
		this.eid = eid;
		this.etitle = etitle;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.e_type = e_type;
		this.status = status;
	}
	
	

}
