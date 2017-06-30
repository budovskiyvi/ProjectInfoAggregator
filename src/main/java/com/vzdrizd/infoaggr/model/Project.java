/**
 * 
 */
package com.vzdrizd.infoaggr.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author V.Budovskiy
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 381944294066184818L;

	@Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	 @Column(name = "name",unique = true,nullable=false)
	 private String name;
	 
	 @Column(name = "description")
	 private String description;
	 
	 @Column(name = "full_description")
	 private String fullDescription;

	 @OneToMany(mappedBy="project")	 
	 private Set<BusinessObject> businessObjects;
	 
	 public Project(String name, String description, String fullDescription){
		 this.name=name;
		 this.description=description;
		 this.fullDescription=fullDescription;
	 }
	 
	 public void setUpdatebleFields(Project project){
		 this.description=project.description;
		 this.fullDescription=project.fullDescription;
	 }
	 
}
