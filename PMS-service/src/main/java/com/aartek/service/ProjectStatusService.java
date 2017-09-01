
package com.aartek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.ProjectStatus;
import com.aartek.repository.ProjectStatusRepository;

@Service
public class ProjectStatusService {
	@Autowired
	private ProjectStatusRepository projectStatusRepository;
	
	
	public ProjectStatus projectservice(ProjectStatus projectStatus)
	{
		System.out.println("In the service Method");
		projectStatusRepository.saveproj(projectStatus);
		return projectStatus;
	}
	public List<ProjectStatus> getservice()
	{
		return projectStatusRepository.fetchResult();
		
	}
	public void deleteproj(Integer id)
	{
		//System.out.println(id);
		projectStatusRepository.deleteproj(id);
	}
	public ProjectStatus getProjectStatus(int id)
	{
		return projectStatusRepository.getProjectStatus(id);
	}
	public ProjectStatus updateProjectStatus(ProjectStatus projectStatus)
	{
		return projectStatusRepository.updateProjectStatus(projectStatus);
	}

	public void setProjectStatusRepository(ProjectStatusRepository projectStatusRepository) {
		this.projectStatusRepository = projectStatusRepository;
	}
	
}
