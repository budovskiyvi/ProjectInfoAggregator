package com.vzdrizd.infoaggr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vzdrizd.infoaggr.dao.ProjectDao;
import com.vzdrizd.infoaggr.model.Project;



@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	@Transactional
	public void addProject(Project project) {
		this.projectDao.addProject(project);
	}

	@Override
	@Transactional
	public void updateProject(Project project) {
		this.projectDao.updateProject(project);
	}

	@Override
	@Transactional
	public void removeProject(int id) {
		this.projectDao.removeProject(id);
	}

	@Override
	@Transactional
	public Project getProjectById(int id) {
		return this.projectDao.getProjectById(id);
	}

	@Override
	@Transactional
	public List<Project> listProjects() {
		int i=1;
		i=i+1;
		return this.projectDao.listProjects();
	}

}
