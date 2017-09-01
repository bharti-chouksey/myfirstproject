package com.aartek.wscontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aartek.model.ProjectStatus;
import com.aartek.service.ProjectStatusService;

@Controller
public class Loginws {
	
	@Autowired
	private ProjectStatusService projectStatusService;
	
	@RequestMapping(value="/logingetid",method=RequestMethod.GET)
	public @ResponseBody List<ProjectStatus> show(ModelMap map)
	{
		map.put("ProjectStatus", new ProjectStatus());
		List<ProjectStatus> project = projectStatusService.getservice();
		map.addAttribute("projects", project);
		
		System.out.println("loginid");
		return project;
		
	}
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public @ResponseBody ModelAndView showProject(ModelMap map) {
		map.put("ProjectStatus", new ProjectStatus());
		List<ProjectStatus> list=projectStatusService.getservice();
		map.addAttribute("projects", list);
		return new ModelAndView ("projectStatus","user",list);
	}

}
