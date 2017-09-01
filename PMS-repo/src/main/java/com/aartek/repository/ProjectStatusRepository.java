package com.aartek.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aartek.model.ProjectStatus;

@Repository
@Transactional
public class ProjectStatusRepository {
	@Autowired 
	private HibernateTemplate hibernateTemplate;
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProjectStatus saveproj(ProjectStatus projectStatus )
	{
		if(projectStatus != null)
		{
		hibernateTemplate.saveOrUpdate(projectStatus);
//			sessionFactory.getCurrentSession().saveOrUpdate(projectStatus);
		return projectStatus;
		}
		else 
			return null;
		
	}
	public List<ProjectStatus> fetchResult()
	{
		List<ProjectStatus> fetch = hibernateTemplate.find("from ProjectStatus");
				return fetch;
		
	}
	@SuppressWarnings("unchecked")
	public List<ProjectStatus> validateprojname(String proname)
	
	{
		return hibernateTemplate.find("from ProjectStatus p where p.pro_name=?",proname);
		
	}
	
	public void deleteproj(Integer id)
	{
			
		hibernateTemplate.delete(hibernateTemplate.get(ProjectStatus.class, id));
		
		
	}

	public ProjectStatus getProjectStatus(int id)
	{
		 return (ProjectStatus) hibernateTemplate.get(ProjectStatus.class, id);
	}
	public ProjectStatus updateProjectStatus(ProjectStatus projectStatus)
	{
		hibernateTemplate.update(projectStatus);
		return projectStatus;
	}
}
