/**
 * 
 */
package com.vzdrizd.infoaggr.service;

import java.util.Collection;

import com.vzdrizd.infoaggr.model.Document;

/**
 * @author V.Budovskiy
 *
 */
public interface DocumentService {
	
	Collection <Document> findAll();
	
	Collection <Document> findByName(String name);
	
	Document findOne(Long id);
	
	Document create(Document document);
	
	Document update(Document document);
	
	void delete(Long id);
}
