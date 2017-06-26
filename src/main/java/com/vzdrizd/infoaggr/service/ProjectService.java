/**
 * 
 */
package com.vzdrizd.infoaggr.service;

import java.util.Collection;

import com.vzdrizd.infoaggr.model.Project;

/**
 * @author V.Budovskiy
 *
 */
public interface ProjectService {

	Collection<Project> findAll();
	
	Project findOne(Long id);
	
	Project create(Project project);
	
	Project update(Project project);
	
	void delete(Long id);
	
}
