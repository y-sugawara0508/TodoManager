package com.example.TodoManager.form;

import com.example.TodoManager.util.Login;

@Login
public class LoginForm {

	/** メールアドレス*/
	private String address;

	/**パスワード*/
	private String personalPass;

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

}
