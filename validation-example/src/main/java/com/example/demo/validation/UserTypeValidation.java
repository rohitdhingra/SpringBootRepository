package com.example.demo.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserTypeValidation implements ConstraintValidator<ValidateUserType, String>{

	@Override
	public boolean isValid(String userType, ConstraintValidatorContext context) {
		List<String> userTypes = Arrays.asList("Permanent","Vendor");
		return userTypes.contains(userType);
	}

}
