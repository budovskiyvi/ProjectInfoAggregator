/**
 * 
 */
package com.vzdrizd.infoaggr.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vzdrizd.infoaggr.model.Project;
import com.vzdrizd.infoaggr.service.BusinessObjectService;
import com.vzdrizd.infoaggr.service.ProjectService;

/**
 * @author V.Budovskiy
 *
 */
@Controller
public class ProjectsController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private BusinessObjectService businessObjectService;
	
	@RequestMapping(value="/projects")
	public ModelAndView directToProjectsPage()
	{
		
		Collection<Project> projects=projectService.findAll();
		return new ModelAndView("projects", "projects", projects);
	}
	
	@RequestMapping(value="/project")
	public ModelAndView project(@ModelAttribute("project") Project project)	
	{
		Long i=project.getId();
		Long j=i;
		return null;
	}
	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		Project project = new Project();
		project.setDescription("smth");
		project.setName("gh2");
		Project createdProject=projectService.create(project);
		Project project2 = new Project();
		project2.setDescription("smth");
		project2.setName("gh2");
		Project createdProject2=projectService.create(project2);
		
		Collection<Project> foud = projectService.findAll(); 
		model.addAttribute("name", foud.size());
		
		return "greeting";
	}
}
