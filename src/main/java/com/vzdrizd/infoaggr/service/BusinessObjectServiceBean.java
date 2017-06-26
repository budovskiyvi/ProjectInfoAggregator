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

import com.vzdrizd.infoaggr.dao.BusinessObjectDao;
import com.vzdrizd.infoaggr.model.BusinessObject;

/**
 * @author V.Budovskiy
 *
 */

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BusinessObjectServiceBean implements BusinessObjectService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BusinessObjectDao businessObjectDao;

	@Override
	public Collection<BusinessObject> findAll() {
		logger.info("> findAll");

		Collection<BusinessObject> businessObjects = businessObjectDao.findAll();

		logger.info("< findAll");

		return businessObjects;
	}

	@Override
	public BusinessObject findOne(Long id) {

		logger.info("> findOne id:{}", id);

		BusinessObject businessObject = businessObjectDao.findOne(id);

		logger.info("< findOne id:{}", id);
		return businessObject;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public BusinessObject create(BusinessObject businessObject) {
		logger.info("> create");

		if (businessObject.getId() != null) {
			logger.error("Attempted to create a Greeting, but id attribute was not null.");
			throw new EntityExistsException("The id attribute must be null to persist a new entity.");
		}

		BusinessObject savedBusinessObject = businessObjectDao.save(businessObject);
		logger.info("< create");

		return savedBusinessObject;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public BusinessObject update(BusinessObject businessObject) {

		logger.info("> update id:{}", businessObject.getId());

		BusinessObject businessObjectToUpdate = findOne(businessObject.getId());
		if (businessObjectToUpdate == null) {
			logger.error("Attempted to update a Greeting, but the entity does not exist.");
			throw new NoResultException("Requested entity not found.");
		}

		businessObjectToUpdate.setDescription(businessObject.getDescription());
		BusinessObject updatedBusinessObject = businessObjectDao.save(businessObjectToUpdate);

		logger.info("< update id:{}", businessObject.getId());

		return updatedBusinessObject;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Long id) {
		logger.info("> delete id:{}", id);

		businessObjectDao.delete(id);

		logger.info("< delete id:{}", id);

	}

}
