package com.vzdrizd.infoaggr.service;

import java.util.Collection;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vzdrizd.infoaggr.AbstractTest;
import com.vzdrizd.infoaggr.model.Project;

public class ProjectServiceTest  extends AbstractTest{
	
	@Autowired
	private ProjectService service;
	
	@Test
    public void testCreate() {
		Project entity = new Project();
		
		entity.setName("Excample");
		entity.setDescription("Excample Description");
		
		Project createdEntity = service.create(entity);
		
		Assert.assertNotNull("failure - expected not null", createdEntity);
		Assert.assertNotNull("failure - expected id attribute not null", createdEntity.getId());
		Assert.assertEquals("failure - expected text attribute match", "Excample",
				createdEntity.getName());

	}

	@Test
	public void testFindAll() {
		Project entity1 = new Project();
		entity1.setName("Excample1");
		entity1.setDescription("Excample1 Description");

		Project createdEntity1 = service.create(entity1);

		Project entity2 = new Project();
		entity2.setName("Excample2");
		entity2.setDescription("Excample2 Description");

		Project createdEntity2 = service.create(entity2);

		Collection<Project> list = service.findAll();
		Assert.assertNotNull("failure - expected not null", list);
	}

	@Test
	public void testFindOne() {
		Project entity1 = new Project();
		entity1.setName("Excample1");
		entity1.setDescription("Excample1 Description");

		Project createdEntity1 = service.create(entity1);

		Project foundEntity = service.findOne(createdEntity1.getId());

		Assert.assertNotNull("failure - expected not null", foundEntity);
		Assert.assertEquals("failure - expected id attribute match", createdEntity1.getId(), foundEntity.getId());
	}

	@Test
	public void testFindOneNotFound() {
		Long id = Long.MAX_VALUE;
		Project entity = service.findOne(id);
		Assert.assertNull("failure - expected null", entity);
	}

	@Test
	public void testCreateWithId() {
		Exception exception = null;

		Project entity = new Project();
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
		
		Project entity = new Project();
		entity.setName("Excample");
		entity.setDescription("Excample Description");
		
		Project createdEntity = service.create(entity);		
		Assert.assertNotNull("failure - expected not null", createdEntity);
		
		String updatedText = createdEntity.getDescription()+" test";
		createdEntity.setDescription(updatedText);
		
		Project updatedEntity=service.update(createdEntity);
		
		Assert.assertNotNull("failure - expected not null", updatedEntity);
		Assert.assertEquals("failure - expected id attribute match", createdEntity.getId(),
                updatedEntity.getId());
		Assert.assertEquals("failure - expected text attribute match",
                updatedText, updatedEntity.getDescription());
		
	}
	
	@Test
    public void testUpdateNotFound() {
		Exception exception = null;
		Project entity = new Project();
		entity.setId(Long.MAX_VALUE);
		entity.setName("Test");
		entity.setDescription("Test Disc");
		
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
		Project entity = new Project();
		entity.setName("Excample");
		entity.setDescription("Excample Description");
		
		Project createdEntity = service.create(entity);	
		Assert.assertNotNull("failure - expected not null", createdEntity);
		service.delete(createdEntity.getId());
		
		Project deletedEntity=service.findOne(createdEntity.getId());
		
		Assert.assertNull("failure - expected null", deletedEntity);
	}
}
