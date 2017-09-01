package com.aartek.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.aartek.model.Registration;
import com.aartek.service.LoginService;
import com.aartek.validator.LoginValidator;
@Controller
public class LoginController {
	@Autowired
	private LoginService loginservice;
	@Autowired
	private LoginValidator loginValidator;
	@RequestMapping("/login")
	public String showLogin(Map<String, Object> map,Locale locale) 
	{
		System.out.println("Intialized LoginController....!!!");
		map.put("Registration", new Registration());
		System.out.println(locale);
		return "login";
	}

	@RequestMapping(value="/showLogin", method = {RequestMethod.GET,RequestMethod.POST})
	public String checkLogin(@ModelAttribute("Registration") Registration registration,BindingResult result)
	{
		System.out.println("inside check controller");
		loginValidator.validate(registration, result);
		if(result.hasErrors())
		{
			return "login";
		}
//		System.out.println(registration.getEmail());
//		System.out.println(registration.getPassword());
		//map.put("User", new User());
		registration = loginservice.validates(registration);
		if(registration == null)
		{
			System.out.println("invalid user ");
			
			return "redirect:/login.do";
		}
		else {
			
			return "show";
		}
		
		
		
	}

}
