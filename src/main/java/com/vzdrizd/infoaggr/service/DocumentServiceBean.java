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

import com.vzdrizd.infoaggr.dao.DocumentDao;
import com.vzdrizd.infoaggr.model.Document;

/**
 * @author V.Budovskiy
 *
 */
@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true)
public class DocumentServiceBean implements DocumentService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DocumentDao documentDao;
	/* (non-Javadoc)
	 * @see com.vzdrizd.infoaggr.service.DocumentService#findAll()
	 */
	@Override
	public Collection<Document> findAll() {
		logger.info("> start Document findAll");
		Collection<Document> foundDocuments=documentDao.findAll();
		logger.info("< stop Document findAll");
		return foundDocuments;
	}


	@Override
	public Collection<Document> findByName(String name) {
		logger.info("> start Document findByName name:{}", name);
		Collection<Document> foundDocuments=documentDao.findByName(name);
		logger.info("< end Document findByName name:{}", name);
		return foundDocuments;
	}


	@Override
	public Document findOne(Long id) {
		logger.info("> start Document findOne id:{}", id);
		Document foundDocument=documentDao.findOne(id);
		logger.info("< end Document findOne id:{}", id);
		return foundDocument;
	}


	@Override	
	@Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
	public Document create(Document document) {
		logger.info("> start Document create");
		if(document.getId()!=null){
			logger.error(
                    "Attempted to create a Document, but id attribute was not null.");
            throw new EntityExistsException(
                    "The id attribute must be null to persist a new entity.");
		}
		
		Document createdDocument = documentDao.save(document);
		
		logger.info("< stop Document create");
		return createdDocument;
	}

	@Override
	@Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
	public Document update(Document document) {
		logger.info("> start Document update id:{}", document.getId());
		Document documentToUpdate = findOne(document.getId());
		if(documentToUpdate==null){
			logger.error(
                    "Attempted to update a Document, but the entity does not exist.");
            throw new NoResultException("Requested entity not found.");
		}
		documentToUpdate.setUpdatebleFields(document);
		Document updatedDocument=documentDao.save(documentToUpdate);
		logger.info("< stop Document update id:{}", document.getId());
		return null;
	}

	@Override
	@Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
	public void delete(Long id) {
		logger.info("> start delete Document id:{}", id);
		documentDao.delete(id);
		logger.info("< stop delete Document id:{}", id);

	}

}
