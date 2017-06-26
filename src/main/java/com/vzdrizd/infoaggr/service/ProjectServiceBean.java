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
		logger.info("> findAll");
		
		Collection<Project> projects=projectDao.findAll();
		
		logger.info("< findAll");
		
		return projects;
	}

	@Override
	public Project findOne(Long id) {		
		
		 logger.info("> findOne id:{}", id);
		 
		 Project project=projectDao.findOne(id);
		 
		 logger.info("< findOne id:{}", id);
		return project;
	}

	@Override
	@Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
	public Project create(Project project) {
		logger.info("> create");
		
		if(project.getId()!=null){
			logger.error(
                    "Attempted to create a Greeting, but id attribute was not null.");
            throw new EntityExistsException(
                    "The id attribute must be null to persist a new entity.");
		}
		
		Project savedProject=projectDao.save(project);
		logger.info("< create");
		
		return savedProject;
	}

	@Override
	@Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
	public Project update(Project project) {
		
		logger.info("> update id:{}", project.getId());
		
		Project projectToUpdate=findOne(project.getId());
		if(projectToUpdate==null){
			logger.error(
                    "Attempted to update a Greeting, but the entity does not exist.");
            throw new NoResultException("Requested entity not found.");
		}
		
		projectToUpdate.setDescription(project.getDescription());
		Project updatedProject=projectDao.save(projectToUpdate);
		
		logger.info("< update id:{}", project.getId());		
			
		return updatedProject;
	}

	@Override
	@Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
	public void delete(Long id) {
		logger.info("> delete id:{}", id);
		
		projectDao.delete(id);
		
		logger.info("< delete id:{}", id);
		
	}

}
