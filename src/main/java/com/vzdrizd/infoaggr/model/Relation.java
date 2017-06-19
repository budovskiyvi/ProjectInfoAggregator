package com.vzdrizd.infoaggr.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "relation")
public class Relation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7051557487067991417L;

	@Id
    @Column(name = "relation_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@ManyToOne
	@JoinColumn(name="bo_id")
	private BusinessObject relatedObject;
	
	@ManyToOne
	@JoinColumn(name="relation_type_cd")
	private RelationType relationType;

}
