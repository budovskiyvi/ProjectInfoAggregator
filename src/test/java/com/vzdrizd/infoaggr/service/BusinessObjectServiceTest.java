package com.vzdrizd.infoaggr.service;

import java.util.Collection;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vzdrizd.infoaggr.AbstractTest;
import com.vzdrizd.infoaggr.model.BusinessObject;
import com.vzdrizd.infoaggr.model.Project;

public class BusinessObjectServiceTest extends AbstractTest{

	@Autowired
	private BusinessObjectService service;
	
	@Autowired
	private ProjectService serviceProject;
	
	private Project testProject;
	private Project createdProject;
	
	@Before 
	public void onlyOnce() {
		
		testProject = new Project();
		testProject.setName("Test Name!");
		testProject.setDescription("Test Descr!");
		
		createdProject = serviceProject.create(testProject);

	}

	@Test
	public void testCreate() {
		BusinessObject entity = new BusinessObject();

		entity.setName("Excample");
		entity.setDescription("Excample Description");
		
		entity.setProject(createdProject);

		BusinessObject createdEntity = service.create(entity);

		Assert.assertNotNull("failure - expected not null", createdEntity);
		Assert.assertNotNull("failure - expected id attribute not null", createdEntity.getId());
		Assert.assertNotNull("failure - expected Project attribute not null", createdEntity.getProject());
		Assert.assertEquals("failure - expected text attribute match", "Excample", createdEntity.getName());
	}
	
	@Test
	public void testFindAll() {
		
		BusinessObject entity1 = new BusinessObject();
		entity1.setName("Excample1");
		entity1.setDescription("Excample1 Description");
		entity1.setProject(createdProject);		
		BusinessObject createdEntity1 = service.create(entity1);

		BusinessObject entity2 = new BusinessObject();
		entity2.setName("Excample2");
		entity2.setDescription("Excample2 Description");
		entity2.setProject(createdProject);		
		BusinessObject createdEntity2 = service.create(entity2);

		Collection<BusinessObject> list = service.findAll();
		Assert.assertNotNull("failure - expected not null", list);
	}
	
	@Test
	public void testFindOne() {
		BusinessObject entity1 = new BusinessObject();
		entity1.setName("Excample1");
		entity1.setDescription("Excample1 Description");
		entity1.setProject(createdProject);	
		
		BusinessObject createdEntity1 = service.create(entity1);

		BusinessObject foundEntity = service.findOne(createdEntity1.getId());

		Assert.assertNotNull("failure - expected not null", foundEntity);
		Assert.assertEquals("failure - expected id attribute match", createdEntity1.getId(), foundEntity.getId());
		Assert.assertEquals("failure - expected id of Project attribute match", createdEntity1.getProject().getId(), foundEntity.getProject().getId());
		
	}

	@Test
	public void testFindOneNotFound() {
		Long id = Long.MAX_VALUE;
		BusinessObject entity = service.findOne(id);
		Assert.assertNull("failure - expected null", entity);
	}
	
	@Test
	public void testCreateWithId() {
		Exception exception = null;

		BusinessObject entity = new BusinessObject();
		entity.setId(Long.MAX_VALUE);
		entity.setName("test");

		try {
			service.create(entity);
		} catch (EntityExistsException e) {
			exception = e;
		}
		Assert.assertNotNull("failure - expected exception", exception);
		Assert.assertTrue("failure - expected EntityExistsException", exception instanceof EntityExistsException);
	}
	
	@Test
    public void testUpdate() {
		
		BusinessObject entity = new BusinessObject();
		entity.setName("Excample");
		entity.setDescription("Excample Description");
		entity.setProject(createdProject);	
		
		BusinessObject createdEntity = service.create(entity);		
		Assert.assertNotNull("failure - expected not null", createdEntity);
		
		String updatedText = createdEntity.getDescription()+" test";
		createdEntity.setDescription(updatedText);
		
		BusinessObject updatedEntity=service.update(createdEntity);
		
		Assert.assertNotNull("failure - expected not null", updatedEntity);
		Assert.assertEquals("failure - expected id attribute match", createdEntity.getId(),
                updatedEntity.getId());
		Assert.assertEquals("failure - expected id of Project attribute match", createdEntity.getProject().getId(), updatedEntity.getProject().getId());
		Assert.assertEquals("failure - expected text attribute match",
                updatedText, updatedEntity.getDescription());
		
	}
	
	@Test
    public void testUpdateNotFound() {
		Exception exception = null;
		BusinessObject entity = new BusinessObject();
		entity.setId(Long.MAX_VALUE);
		entity.setName("Test");
		entity.setDescription("Test Disc");
		entity.setProject(createdProject);	
		
		try {
            service.update(entity);
        } catch (NoResultException e) {
            exception = e;
        }

        Assert.assertNotNull("failure - expected exception", exception);
        Assert.assertTrue("failure - expected NoResultException",
                exception instanceof NoResultException);
	}
	
	@Test
    public void testDelete() {
		BusinessObject entity = new BusinessObject();
		entity.setName("Excample");
		entity.setDescription("Excample Description");
		entity.setProject(createdProject);
		
		BusinessObject createdEntity = service.create(entity);	
		Assert.assertNotNull("failure - expected not null", createdEntity);
		service.delete(createdEntity.getId());
		
		BusinessObject deletedEntity=service.findOne(createdEntity.getId());
		
		Assert.assertNull("failure - expected null", deletedEntity);
		
		Project projectEntity = serviceProject.findOne(createdProject.getId());
		Assert.assertNotNull("failure - expected not Project null after delete", projectEntity);
	}
}
