package com.vzdrizd.infoaggr.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class BusinessObject {
	
	@Id
	@Column(name = "bo_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	

	@Column(name = "name")
	 private String name;
	 
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	@OneToMany(mappedBy="relatedObject")	 
	 private Set<Relation> relations;

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
	
	public Set<Relation> getRelations() {
		return relations;
	}

	public void setRelations(Set<Relation> relations) {
		this.relations = relations;
	}
	
	
}
