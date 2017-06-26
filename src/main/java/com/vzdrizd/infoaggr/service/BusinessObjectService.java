package com.vzdrizd.infoaggr.service;

import java.util.Collection;

import com.vzdrizd.infoaggr.model.BusinessObject;

/**
 * @author V.Budovskiy
 *
 */
public interface BusinessObjectService {

	Collection<BusinessObject> findAll();

	BusinessObject findOne(Long id);

	BusinessObject create(BusinessObject businessObject);

	BusinessObject update(BusinessObject businessObject);

	void delete(Long id);
}
