package com.vzdrizd.infoaggr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vzdrizd.infoaggr.model.Project;



@Repository
public class ProjectDaoImpl implements ProjectDao {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public void addProject(Project project) {		
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(project);
        logger.info("Project successfully saved. Project details: " + project);		
	}

	@Override
	public void updateProject(Project project) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(project);
		logger.info("Project successfully update. Project details: " + project);
	}

	@Override
	public void removeProject(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Project project = (Project) session.load(Project.class, new Integer(id));
        if(project!=null){
            session.delete(project);
        }
        logger.info("Project successfully removed. Project details: " + project);
	}

	@Override
	public Project getProjectById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Project project = (Project) session.load(Project.class, new Integer(id));
		logger.info("Project successfully loaded. Project details: " + project);

		return project;
	}

	@Override
	public List<Project> listProjects() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Project> projectList = session.createQuery("from Project").list();

        for(Project project: projectList){
            logger.info("Project list: " + project);
        }

        return projectList;
	}


	
}
