/**
 * 
 */
package com.vzdrizd.infoaggr.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "bus_obj")
public class BusinessObject implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 5472225646645716499L;
	public BusinessObject(String name, String description, Project project)
	{
		this();
		this.name=name;
		this.description=description;
		this.project=project;
	}
	@Id
    @Column(name = "bo_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "name",unique = true,nullable=false)
	 private String name;
	 
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="project_id",nullable=false)
	private Project project;
	
	@OneToMany(mappedBy="inRelatedObject")	 
	 private Set<Relation> inRelations=new HashSet<>();
	
	@OneToMany(mappedBy="outRelatedObject")	 
	 private Set<Relation> outRelations=new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "bo_doc", 
			   joinColumns = @JoinColumn(name = "bo_id"),
					   inverseJoinColumns = @JoinColumn(name = "document_id"))
	private Set <Document> documents=new HashSet<>(); 
	
	
	public void setUpdatebleFields(BusinessObject businessObject)
	{
		this.description=businessObject.description;
		this.inRelations=businessObject.inRelations;
		this.outRelations=businessObject.outRelations;
		this.documents=businessObject.documents;
	}
	
	public void addDocument(Document document)
	{
		addDocument(document,true);
	}
	
	public void addDocument(Document document, boolean needDocument)
	{
		if(this.documents.contains(document))
		{
			this.documents.remove(document);
			this.documents.add(document);
		}
		else
		{
			this.documents.add(document);
		}
		if(needDocument)
		{
			document.addBusinessObject(this, false);
		}
	}
	
}
