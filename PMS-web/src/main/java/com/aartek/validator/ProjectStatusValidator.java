package com.aartek.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.ProjectStatus;
import com.aartek.repository.ProjectStatusRepository;

@Component
public class ProjectStatusValidator implements Validator {
	@Autowired
	private ProjectStatusRepository projectStatusRepository;

	public boolean supports(Class<?> clazz) {
		return ProjectStatus.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ProjectStatus projectStatus = (ProjectStatus) target;
		ValidationUtils.rejectIfEmpty(errors, "pro_name", "error.projectname.empty");
		ValidationUtils.rejectIfEmpty(errors, "client_name", "error.clientname.empty");
		ValidationUtils.rejectIfEmpty(errors, "start_date", "error.startdate.empty");
		ValidationUtils.rejectIfEmpty(errors, "end_date", "error.enddate.empty");

		if (projectStatus.getPro_name() != null && projectStatus.getPro_name().trim().length() > 0) {
			if (projectStatus.getPro_name().length() == 30) {
				errors.rejectValue("pro_name", "error.proname.len");
			}
		}

		if (projectStatus.getClient_name() != null && projectStatus.getClient_name().trim().length() > 0) {
			if (projectStatus.getClient_name().length() == 30) {
				errors.rejectValue("client_name", "error.client.len");
			}
		}

		if (projectStatus.getStart_date() != null && projectStatus.getStart_date().trim().length() > 0) {
			if (projectStatus.getStart_date().contains("/") != true
					&& projectStatus.getStart_date().contains("-") != true) {
				errors.rejectValue("start_date", "error.startdate.rule");
			}
			
		}
		
		if(projectStatus.getEnd_date() != null && projectStatus.getEnd_date().trim().length()>0)
		{
			if(projectStatus.getEnd_date().contains("/")!=true
					&& projectStatus.getEnd_date().contains("-")!=true)
			{
				errors.rejectValue("end_date","error.enddate.rule");
			}
		}
	boolean b =	projectStatusRepository.validateprojname(projectStatus.getPro_name()).isEmpty();
	if(b== false)
	{
		errors.rejectValue("pro_name", "error.project.exist");
	}
		
	}

}
