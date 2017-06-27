/**
 * 
 */
package com.vzdrizd.infoaggr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vzdrizd.infoaggr.model.Relation;

/**
 * @author V.Budovskiy
 *
 */
public interface RelationDao extends JpaRepository<Relation,Long> {

}
