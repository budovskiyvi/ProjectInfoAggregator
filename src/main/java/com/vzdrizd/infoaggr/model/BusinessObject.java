package com.vzdrizd.infoaggr.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class BusinessObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -801273507290334422L;


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
	
	@OneToMany(mappedBy="inRelatedObject")	 
	 private Set<Relation> inRelations;
	
	@OneToMany(mappedBy="outRelatedObject")	 
	 private Set<Relation> outRelations;

	
	
}
