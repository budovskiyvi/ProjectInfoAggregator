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
}
