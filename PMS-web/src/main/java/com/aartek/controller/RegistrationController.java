package com.aartek.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aartek.model.Registration;
import com.aartek.service.RegistrationService;
import com.aartek.validator.RegistrationValidator;

@Controller
@SuppressWarnings("unused")
public class RegistrationController {
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private RegistrationValidator registrationValidator;
	
	@RequestMapping("/registration")
	public String showRegistraion(Map<String,Object> map)
	{
		System.out.println("Inside RagistrationController");
		map.put("Registration", new Registration());
		return "registration";
	}
	@RequestMapping(value="/registration", method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("Registration") Registration registration ,BindingResult result, Map<String, Object> map, HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("inside check controller");
		registrationValidator.validate(registration, result);
		if(result.hasErrors())
		{
			return "registration";
		}
		System.out.println(registration.getFname());
		//map.put("Registration", new Registration());
		registrationService.validate(registration);
		return "redirect:/registration.do";
		
	}

	/*@RequestMapping(value="/registration", method = RequestMethod.POST)
	public String checkLogin(@Valid Registration registration ,BindingResult result, RedirectAttributes redirectAttributes,ModelMap map, HttpServletRequest request, HttpServletResponse response)
	{
		map.addAttribute("Registration", new Registration());
		redirectAttributes.addFlashAttribute("rs", registrationService.validate(registration));
		//registrationService.validate(registration);
		return "redirect:/home.do";
		
	}*/

}
