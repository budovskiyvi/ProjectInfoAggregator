/**
 * 
 */
package com.vzdrizd.infoaggr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vzdrizd.infoaggr.model.BusinessObject;
import com.vzdrizd.infoaggr.model.Project;

/**
 * @author V.Budovskiy
 *
 */
@Repository
public interface BusinessObjectDao extends JpaRepository<BusinessObject,Long> {
	List<BusinessObject> findByProject(Project project);
}
