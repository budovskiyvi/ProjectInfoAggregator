package com.vzdrizd.infoaggr.model;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class BusinessObject {
	
	@Id
	@Column(name = "bo_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "bo_name")
	 private String name;
	 
	@Column(name = "bo_description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;

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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	
}
