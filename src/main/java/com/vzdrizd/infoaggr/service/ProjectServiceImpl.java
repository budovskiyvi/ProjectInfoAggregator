package com.vzdrizd.infoaggr.service;

import java.util.List;

import com.vzdrizd.infoaggr.dao.ProjectDao;
import com.vzdrizd.infoaggr.model.Project;


public class ProjectServiceImpl implements ProjectService {

	
	private ProjectDao projectDao;

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
	@Override
	public void addProject(Project Project) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProject(Project project) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProject(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Project getProjectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> listProjects() {
		// TODO Auto-generated method stub
		return null;
	}

}
