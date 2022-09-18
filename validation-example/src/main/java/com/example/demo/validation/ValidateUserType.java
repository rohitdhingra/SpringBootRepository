package com.example.demo.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UserTypeValidation.class)
public @interface ValidateUserType {
	
	public String message() default "Invalid User Type: It should be either Permanent or Vendor";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
