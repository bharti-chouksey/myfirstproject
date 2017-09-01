package com.aartek.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.Registration;
import com.aartek.repository.LoginRepository;

@Component
public class LoginValidator implements Validator{
	@Autowired
	private LoginRepository repository;

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Registration.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Registration registration = (Registration) target;
		ValidationUtils.rejectIfEmpty(errors, "email", "error.emailId.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.password.empty");
		
	// repository.adminSignIn(registration.getEmail(), registration.getPassword());

		
		
		
	}
	
	

}
