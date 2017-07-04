package com.vzdrizd.infoaggr.service;

import java.util.Collection;

import com.vzdrizd.infoaggr.model.BusinessObject;
import com.vzdrizd.infoaggr.model.Project;

/**
 * @author V.Budovskiy
 *
 */
public interface BusinessObjectService {

	Collection<BusinessObject> findAll();

	BusinessObject findOne(Long id);

	BusinessObject create(BusinessObject businessObject);

	BusinessObject update(BusinessObject businessObject);
	
	Collection <BusinessObject> findByProject(Project project);

	void delete(Long id);
}
