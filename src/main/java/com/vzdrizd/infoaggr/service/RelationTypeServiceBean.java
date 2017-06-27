/**
 * 
 */
package com.vzdrizd.infoaggr.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vzdrizd.infoaggr.dao.RelationTypeDao;
import com.vzdrizd.infoaggr.model.RelationType;

/**
 * @author V.Budovskiy
 *
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RelationTypeServiceBean implements RelationTypeService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RelationTypeDao relationTypeDao;

	/* (non-Javadoc)
	 * @see com.vzdrizd.infoaggr.service.RelationTypeService#findAll()
	 */
	@Override
	public Collection<RelationType> findAll() {
		
		logger.info(">RelationType findAll");
		Collection<RelationType> relationTypes=relationTypeDao.findAll();
		logger.info("<RelationType findAll");
		return relationTypes;
	}

	/* (non-Javadoc)
	 * @see com.vzdrizd.infoaggr.service.RelationTypeService#findOne(java.lang.String)
	 */
	@Override
	public RelationType findOne(String code) {
		
		logger.info("> findOne cd:{}", code);
		RelationType relationType = relationTypeDao.findOne(code);
		logger.info("< findOne cd:{}", code);
		return relationType;
	}

	/* (non-Javadoc)
	 * @see com.vzdrizd.infoaggr.service.RelationTypeService#create(com.vzdrizd.infoaggr.model.RelationType)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public RelationType create(RelationType relationType) {
		logger.info(">RelationType create");
		// TODO Auto-generated method stub
		RelationType createdRelationType=relationTypeDao.save(relationType);
		logger.info("<RelationType create");
		return createdRelationType;
	}


}
