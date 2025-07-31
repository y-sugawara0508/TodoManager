package com.example.TodoManager.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personal")
public class Personal {
	
	@Id
	private Integer personalId;
	
	@Column
	private String personalName;
	
	@Column
	private String address;
	
	@Column
	private String personalPass;
	
	@Column
	private Date birthday;
	
	public Integer getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Integer personalId) {
		this.personalId = personalId;
	}

	public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPersonalPass() {
		return personalPass;
	}

	public void setPersonalPass(String personalPass) {
		this.personalPass = personalPass;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
