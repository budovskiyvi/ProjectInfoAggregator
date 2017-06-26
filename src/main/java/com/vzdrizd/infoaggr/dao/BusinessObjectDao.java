/**
 * 
 */
package com.vzdrizd.infoaggr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vzdrizd.infoaggr.model.BusinessObject;

/**
 * @author V.Budovskiy
 *
 */
@Repository
public interface BusinessObjectDao extends JpaRepository<BusinessObject,Long> {

}
