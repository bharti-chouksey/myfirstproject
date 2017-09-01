package com.aartek.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aartek.model.ProjectStatus;
import com.aartek.service.ProjectStatusService;
import com.aartek.validator.ProjectStatusValidator;
@Controller
public class ProjectStatusController {

	@Autowired
	private ProjectStatusService projectStatusService;
	@Autowired
	private ProjectStatusValidator projectStatusValidator;
	
	@RequestMapping("/projectStatus")
	public String showProject(ModelMap map )
	{
		System.out.println("Inside Project Controller");
		map.put("ProjectStatus", new ProjectStatus());
		List<ProjectStatus> project = projectStatusService.getservice();
		map.addAttribute("projects", project);
		return "projectStatus";
	}
	@RequestMapping(value="/projectStatus", method = RequestMethod.POST)
	public String saveProject(@ModelAttribute("ProjectStatus") ProjectStatus projectStatus,BindingResult result, ModelMap map)
	{
		System.out.println("inside save controller");
		List<ProjectStatus> project = projectStatusService.getservice();
		map.addAttribute("projects", project);
		projectStatusValidator.validate(projectStatus, result);
		if(result.hasErrors())
		{
			
			return "projectStatus";
		}
		projectStatusService.projectservice(projectStatus);
		return "redirect:/projectStatus.do";
	}
	@RequestMapping(value = "/deleteproj", method = RequestMethod.GET)
    public String deleteproj(HttpServletRequest request) {
        int projectstatusid = Integer.parseInt(request.getParameter("id"));
        projectStatusService.deleteproj(projectstatusid);
        return "redirect:/projectStatus.do";
    }
	
	@RequestMapping(value="/empeditform")  
    public String edit(HttpServletRequest request ,ModelMap map){  
		int pid = Integer.parseInt(request.getParameter("id"));
		ProjectStatus projectStatus = projectStatusService.getProjectStatus(pid);
        map.addAttribute("empeditform", projectStatus);
        return"empeditform";
    }  
	
	/* It updates model object. */  
    @RequestMapping(value="/empeditform",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("empeditform") ProjectStatus projectStatus,BindingResult result){ 
    	projectStatusValidator.validate(projectStatus, result);
		if(result.hasErrors())
		{
			
			return "empeditform";
		}
        projectStatusService.updateProjectStatus(projectStatus); 
        return "redirect:/projectStatus.do"; 
    }  
}
