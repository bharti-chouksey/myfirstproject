package com.aartek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.Registration;
import com.aartek.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	public Registration validates(Registration registration)
	{
		
//		System.out.println("LoginService \t"+user.getEmail()+"\t"+user.getPassword());
		//loginRepository.val(user);
		List<Registration> list = loginRepository.adminSignIn(registration.getEmail(),registration.getPassword());
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
		
	}

}
