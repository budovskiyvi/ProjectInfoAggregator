package com.vzdrizd.infoaggr.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
