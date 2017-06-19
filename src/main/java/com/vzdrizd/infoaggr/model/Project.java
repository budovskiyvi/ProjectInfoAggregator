package com.vzdrizd.infoaggr.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 67648093484206483L;

	@Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	 @Column(name = "name")
	 private String name;
	 
	 @Column(name = "description")
	 private String description;
	 
	 @OneToMany(mappedBy="project")	 
	 private Set<BusinessObject> businessObjects;


}
