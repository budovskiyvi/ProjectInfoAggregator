/**
 * 
 */
package com.vzdrizd.infoaggr.service;


import java.util.Collection;

import com.vzdrizd.infoaggr.model.Relation;

/**
 * @author V.Budovskiy
 *
 */
public interface RelationService {
	Collection<Relation> findAll();

	Relation findOne(Long id);

	Relation create(Relation relation);

	Relation update(Relation relation);

	void delete(Long id);
}
