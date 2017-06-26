/**
 * 
 */
package com.vzdrizd.infoaggr.service;

import java.util.Collection;

import com.vzdrizd.infoaggr.model.RelationType;

/**
 * @author V.Budovskiy
 *
 */
public interface RelationTypeService {
	Collection<RelationType> findAll();

	RelationType findOne(String code);

	RelationType create(RelationType relationType);

	RelationType update(RelationType relationType);

	void delete(String code);
}
