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

import com.vzdrizd.infoaggr.dao.RelationDao;
import com.vzdrizd.infoaggr.model.Relation;

/**
 * @author V.Budovskiy
 *
 */
@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true)
public class RelationServiceBean implements RelationService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RelationDao relationDao;

	@Override
	public Collection<Relation> findAll() {
		logger.info("> start Relation findAll");
		Collection<Relation> relations=relationDao.findAll();
		logger.info("< end Relation findAll");
		return relations;
	}

	@Override
	public Relation findOne(Long id) {
		 logger.info("> start Relation findOne id:{}", id);
		 Relation foundRelation=relationDao.findOne(id);
		 logger.info("< end Relation findOne id:{}", id);
		return foundRelation;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Relation create(Relation relation) {
		logger.info(">start Relation create");
		if (relation.getId() != null) {
			logger.error("Attempted to create a Relation, but id attribute was not null.");
			throw new EntityExistsException("The id attribute must be null to persist a new entity.");
		}
		Relation savedRelation = relationDao.save(relation);
		logger.info("< end Relation create");
		return savedRelation;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Relation update(Relation relation) {
		logger.info("> start Relation update id:{}", relation.getId());
		Relation relationToUpdate=relationDao.findOne(relation.getId());
		if(relationToUpdate==null){
			logger.error("Attempted to update a Relation, but the entity does not exist.");
			throw new NoResultException("Requested entity not found.");
		}
		relationToUpdate.setRelationType(relation.getRelationType());
		Relation updatedRelation=relationDao.save(relationToUpdate);
		logger.info("< end Relation update id:{}", relation.getId());
		return updatedRelation;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Long id) {
		logger.info("> start delete Relation id:{}", id);
		relationDao.delete(id);
		logger.info("> end delete Relation id:{}", id);
	}

}
