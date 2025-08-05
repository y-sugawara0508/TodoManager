package com.example.TodoManager.util;
 
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
 
/*独自メッセージを表示させるための独自	バリデーションアノテーションを定義
*バリデーションアノテーションを明示的に指定 
*/
@Documented
@Constraint(validatedBy = LoginValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Login {
	/*デフォルトメッセージの設定。	*/
	String message() default "間違っています。";
 
	Class<?>[] groups() default {};
 
	Class<? extends Payload>[] payload() default {};
 
	String fieldAddress() default "address";
 
	String fieldpersonalPass() default "personalPass";
}