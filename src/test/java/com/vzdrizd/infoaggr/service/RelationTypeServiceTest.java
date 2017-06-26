/**
 * 
 */
package com.vzdrizd.infoaggr.service;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vzdrizd.infoaggr.AbstractTest;
import com.vzdrizd.infoaggr.model.RelationType;

/**
 * @author V.Budovskiy
 *
 */
public class RelationTypeServiceTest extends AbstractTest {

	@Autowired
	private RelationTypeService service;

	@Test
	public void testCreate() {
		RelationType entity = new RelationType();

		entity.setCode("test_create_cd");
		entity.setInName("IN_TEST_NAME");
		entity.setOutName("OUT_TEST_NAME");

		RelationType createdEntity = service.create(entity);

		Assert.assertNotNull("failure - expected not null", createdEntity);
		Assert.assertEquals("failure - expected text attribute match", "test_create_cd", createdEntity.getCode());

	}

	@Test
	public void testFindAll() {
		RelationType entity1 = new RelationType();
		entity1.setCode("test_find_all_cd1");
		entity1.setInName("IN_TEST_NAME1");
		entity1.setOutName("OUT_TEST_NAME1");
		RelationType reatedEntity1 = service.create(entity1);

		RelationType entity2 = new RelationType();
		entity2.setCode("test_find_all_cd2");
		entity2.setInName("IN_TEST_NAME2");
		entity2.setOutName("OUT_TEST_NAME2");
		RelationType reatedEntity2 = service.create(entity2);

		Collection<RelationType> list = service.findAll();
		Assert.assertNotNull("failure - expected not null", list);
	}

	@Test
	public void testFindOne() {

		RelationType entity = new RelationType();
		entity.setCode("test_find_one_cd");
		entity.setInName("IN_TEST_NAME");
		entity.setOutName("OUT_TEST_NAME");
		RelationType createdEntity = service.create(entity);

		Assert.assertNotNull("failure - expected not null", createdEntity);

		RelationType foundEntity = service.findOne(createdEntity.getCode());
		Assert.assertNotNull("failure - expected not null", foundEntity);
		Assert.assertEquals("failure - expected InName attribute match", createdEntity.getInName(), foundEntity.getInName());

	}
}
