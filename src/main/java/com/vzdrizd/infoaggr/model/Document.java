/**
 * 
 */
package com.vzdrizd.infoaggr.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Document {
	
	public Document(String name,String description,DocumentType documentType,String location){
		this.name=name;
		this.description=description;
		this.documentType=documentType;
		this.location=location;
	}
	@Id
    @Column(name = "document_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "doc_name")
	private String name;
	
	@Column(name = "doc_description")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "document_type")
	private DocumentType documentType;
	
	@Column(name = "doc_location")
	private String location;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "bo_doc", 
			   joinColumns = @JoinColumn(name = "document_id"),
					   inverseJoinColumns = @JoinColumn(name = "bo_id"))
	private Set <BusinessObject> businessObjects; 
	
	public void setUpdatebleFields(){
		
	}
}
