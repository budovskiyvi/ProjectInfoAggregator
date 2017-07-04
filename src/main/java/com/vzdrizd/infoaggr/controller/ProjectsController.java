/**
 * 
 */
package com.vzdrizd.infoaggr.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vzdrizd.infoaggr.model.BusinessObject;
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
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("project", project);
		Project projectForBoSelect=projectService.findOne(project.getId());
		Collection<BusinessObject> bos =businessObjectService.findByProject(projectForBoSelect);
		model.put("bos", businessObjectService.findByProject(project));
		return new ModelAndView("project","model",model);
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
