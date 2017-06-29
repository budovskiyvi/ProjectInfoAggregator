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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "document")
public class Document implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5955820436614700450L;

	public Document(String name,String description,DocumentType documentType,String location){
		this();
		this.name=name;
		this.description=description;
		this.documentType=documentType;
		this.location=location;
	}
	@Id
    @Column(name = "document_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "doc_name",nullable=false)
	private String name;
	
	@Column(name = "doc_description")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "document_type",nullable=false)
	private DocumentType documentType;
	
	@Column(name = "doc_location",nullable=false)
	private String location;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "documents")
	private Set <BusinessObject> businessObjects = new HashSet<>();
	
	@Column(name = "doc_version",nullable=false)
	private int version;
	
	public void setUpdatebleFields(Document document){
		this.description=document.getDescription();
		this.documentType=document.getDocumentType();
		this.location=document.getLocation();
		this.businessObjects=document.getBusinessObjects();
		this.version=document.getVersion();
	}
	
	public void addBusinessObject(BusinessObject businessObject)
	{
		addBusinessObject(businessObject,true);
	}
	
	public void addBusinessObject(BusinessObject businessObject, boolean needUpdateBo) {
		if (this.businessObjects.contains(businessObject)) {
			this.businessObjects.remove(businessObject);
			this.businessObjects.add(businessObject);
		} else {
			this.businessObjects.add(businessObject);
		}
		if(needUpdateBo)
		{
			businessObject.addDocument(this, false);
		}
	}
}
