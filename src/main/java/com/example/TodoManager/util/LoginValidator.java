package com.example.TodoManager.util;

import java.lang.reflect.Field;

/*
* Login.javaにて定義したバリデーションの処理内容を以下に記述
*/
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.TodoManager.entity.Personal;
import com.example.TodoManager.repository.PersonalRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
 
@Component
public class LoginValidator implements ConstraintValidator<Login, Object> {
 
	@Autowired
	private PersonalRepository personalRepository;
 
	private String fieldAddress;
	private String fieldPersonalPass;
 
	@Override
	public void initialize(Login constraintAnnotation) {
		this.fieldAddress = constraintAnnotation.fieldAddress();
		this.fieldPersonalPass = constraintAnnotation.fieldpersonalPass();
	}
 
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		try {
			Class<?> clazz = value.getClass();
 
			Field addressField = clazz.getDeclaredField(fieldAddress);
			Field passField = clazz.getDeclaredField(fieldPersonalPass);
 
			addressField.setAccessible(true);
			passField.setAccessible(true);
 
			String address = (String) addressField.get(value);
			String personalPass = (String) passField.get(value);
 
			boolean valid = true;
 
			context.disableDefaultConstraintViolation();
			/*
			 * メールアドレス、またはパスワードが未入力の際に表示されるエラーメッセージの設定
			 */
			if (address.isEmpty() || personalPass.isEmpty()) {
				context.buildConstraintViolationWithTemplate("メールアドレス、またはパスワードが未入力です")
						.addPropertyNode(fieldPersonalPass)
						.addConstraintViolation();
				valid = false;
			}
			/*
			 * メールアドレス、またはパスワードが間違っている際に表示されるエラーメッセージの設定
			 */
			if (valid) {
				Personal personal = personalRepository.findByAddressAndPersonalPass(address, personalPass);
				if (personal == null) {
					context.buildConstraintViolationWithTemplate("メールアドレス、またはパスワードが間違っています")
							.addPropertyNode(fieldPersonalPass)
							.addConstraintViolation();
					valid = false;
				}
			}
			return valid;
			/*
			 * 	例外が発生した際にfalseの結果を返却する。
			 */
		} catch (Exception e) {
			return false;
		}
	}
}
 
