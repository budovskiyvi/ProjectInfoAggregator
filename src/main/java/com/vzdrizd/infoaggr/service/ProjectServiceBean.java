/**
 * 
 */
package com.vzdrizd.infoaggr.service;

import java.util.Collection;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vzdrizd.infoaggr.dao.ProjectDao;
import com.vzdrizd.infoaggr.model.Project;


/**
 * @author V.Budovskiy
 *
 */
@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true)
public class ProjectServiceBean implements ProjectService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProjectDao projectDao;

	@Override
	public Collection<Project> findAll() {
		logger.info("> start Project findAll");
		
		Collection<Project> projects=projectDao.findAll();
		
		logger.info("< end Project findAll");
		
		return projects;
	}

	@Override
	public Project findOne(Long id) {		
		
		 logger.info("> start Project findOne id:{}", id);
		 
		 Project project=projectDao.findOne(id);
		 
		 logger.info("< end Project findOne id:{}", id);
		return project;
	}

	@Override
	@Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
	public Project create(Project project) {
		logger.info("> start Project create");
		
		if(project.getId()!=null){
			logger.error(
                    "Attempted to create a Project, but id attribute was not null.");
            throw new EntityExistsException(
                    "The id attribute must be null to persist a new entity.");
		}
		
		Project savedProject=projectDao.save(project);
		logger.info("< end Project create");
		
		return savedProject;
	}

	@Override
	@Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
	public Project update(Project project) {
		
		logger.info("> start Project update id:{}", project.getId());
		
		Project projectToUpdate=findOne(project.getId());
		if(projectToUpdate==null){
			logger.error(
                    "Attempted to update a Project, but the entity does not exist.");
            throw new NoResultException("Requested entity not found.");
		}
		
		projectToUpdate.setDescription(project.getDescription());
		Project updatedProject=projectDao.save(projectToUpdate);
		
		logger.info("< end Project update id:{}", project.getId());		
			
		return updatedProject;
	}

	@Override
	@Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
	public void delete(Long id) {
		logger.info("> start delete Project id:{}", id);
		
		projectDao.delete(id);
		
		logger.info("< end delete Project id:{}", id);
		
	}

}
