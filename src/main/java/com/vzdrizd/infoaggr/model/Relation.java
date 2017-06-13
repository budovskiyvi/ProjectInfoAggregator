package com.vzdrizd.infoaggr.model;

import javax.persistence.*;

@Entity
@Table(name = "relation")
public class Relation {
	
	@Id
    @Column(name = "relation_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@ManyToOne
	@JoinColumn(name="bo_id")
	private BusinessObject relatedObject;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BusinessObject getRelatedObject() {
		return relatedObject;
	}

	public void setRelatedObject(BusinessObject relatedObject) {
		this.relatedObject = relatedObject;
	}

}
