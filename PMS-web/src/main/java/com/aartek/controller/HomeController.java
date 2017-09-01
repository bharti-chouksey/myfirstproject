package com.aartek.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.aartek.model.Registration;

@Controller
public class HomeController {

	 @RequestMapping(value = "/home", method = RequestMethod.GET)
     public String doLogin(HttpServletRequest request,Model model) {
      Registration  rs1 = (Registration) model.asMap().get("rs");
      System.out.println(rs1);
       Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
       if(flashMap != null){
           Registration rs2=  (Registration) flashMap.get("rs");
           System.out.println(rs2);
           return "home";
       }
	return "home";
       	
      
     }

}
