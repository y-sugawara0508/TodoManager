package com.example.TodoManager.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PersonalForm {

	/** ID*/
	private Integer personalId;
	
	/** 名前*/
	private String personalName;
	
	/** メールアドレス*/
	private String address;
 
	/**パスワード*/
	private String personalPass;
	
	/** 生年月日*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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
