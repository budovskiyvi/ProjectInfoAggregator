/**
 * 
 */
package com.vzdrizd.infoaggr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vzdrizd.infoaggr.model.Document;

/**
 * @author V.Budovskiy
 *
 */
public interface DocumentDao extends JpaRepository<Document,Long> {
	List<Document> findByName(String name);
}
