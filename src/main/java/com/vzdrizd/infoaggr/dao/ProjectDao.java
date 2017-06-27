package com.vzdrizd.infoaggr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vzdrizd.infoaggr.model.Project;


public interface ProjectDao extends JpaRepository<Project,Long>{

}
