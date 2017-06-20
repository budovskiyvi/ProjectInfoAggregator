/**
 * 
 */
package com.vzdrizd.infoaggr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vzdrizd.infoaggr.model.Project;
import com.vzdrizd.infoaggr.service.ProjectService;

/**
 * @author V.Budovskiy
 *
 */
@Controller
public class ProjectsController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="/projects")
	public ModelAndView directToProjectsPage()
	{
		List<Project> projects=projectService.listProjects();
		return new ModelAndView("projects", "projects", projects);
	}
}
