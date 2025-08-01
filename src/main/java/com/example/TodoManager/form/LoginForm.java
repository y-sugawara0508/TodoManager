package com.example.TodoManager.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginForm {
	
		/** メールアドレス*/
		@NotNull
		@Size(max=200)
		private String address;
	 
		/**パスワード*/
		@NotBlank
		@NotNull
		@Size(max = 16)
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
