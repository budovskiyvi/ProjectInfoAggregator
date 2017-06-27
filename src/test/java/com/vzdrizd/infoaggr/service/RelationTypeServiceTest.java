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
	public void testService() {
		RelationType entity = new RelationType();

		entity.setCode("test_create_cd");

		RelationType createdEntity = service.create(entity);

		Assert.assertNotNull("failure - expected not null", createdEntity);
		Assert.assertEquals("failure - expected text attribute match", "test_create_cd", createdEntity.getCode());
		
		RelationType foundEntity = service.findOne(createdEntity.getCode());
		Assert.assertEquals("failure - expected code attribute match", createdEntity.getCode(), foundEntity.getCode());
		
		
	}

}
