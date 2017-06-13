package com.vzdrizd.infoaggr.service;

import java.util.List;

import com.vzdrizd.infoaggr.model.Project;

public interface ProjectService {
	 public void addProject(Project Project);

	    public void updateProject(Project project);

	    public void removeProject(int id);

	    public Project getProjectById(int id);

	    public List<Project> listProjects();
}
