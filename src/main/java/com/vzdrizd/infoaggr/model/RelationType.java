package com.vzdrizd.infoaggr.model;

import javax.persistence.*;

@Entity
@Table(name = "relation_type")
public class RelationType {

	@Id
    @Column(name = "relation_type_cd")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	/*@ManyToOne
	@JoinColumn(name="inversre_relation_type_id")
	@Column(name = "inversre_relation_type_id")
	private RelationType inverseRelationType;*/
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	public RelationType getInverseRelationType() {
		return inverseRelationType;
	}

	public void setInverseRelationType(RelationType inverseRelationType) {
		this.inverseRelationType = inverseRelationType;
	}*/
}
