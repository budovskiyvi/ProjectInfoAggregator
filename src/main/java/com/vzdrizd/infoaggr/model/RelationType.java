package com.vzdrizd.infoaggr.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "relation_type")
public class RelationType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5699047085503982080L;

	@Id
    @Column(name = "relation_type_cd")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy="relationType")	 
	 private Set<Relation> relations;
	

}
