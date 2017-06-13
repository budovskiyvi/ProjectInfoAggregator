package com.vzdrizd.infoaggr.dao;

import java.util.List;

import com.vzdrizd.infoaggr.model.Project;


public interface ProjectDao {
	 
	public void addProject(Project project);

	    public void updateProject(Project project);

	    public void removeProject(int id);

	    public Project getProjectById(int id);

	    public List<Project> listProjects();
}
