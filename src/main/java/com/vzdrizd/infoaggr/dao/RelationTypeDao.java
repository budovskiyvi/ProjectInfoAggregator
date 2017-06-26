/**
 * 
 */
package com.vzdrizd.infoaggr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vzdrizd.infoaggr.model.RelationType;

/**
 * @author V.Budovskiy
 *
 */
@Repository
public interface RelationTypeDao extends JpaRepository<RelationType,String>{

}
