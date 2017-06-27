/**
 * 
 */
package com.vzdrizd.infoaggr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author V.Budovskiy
 *
 */
@Getter
@Setter
@Entity
@Table(name = "relation")
public class Relation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8860940123686863915L;
	
	@Id
    @Column(name = "relation_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="in_bo_id",nullable=false)
	private BusinessObject inRelatedObject;
	
	@ManyToOne
	@JoinColumn(name="out_bo_id",nullable=false)
	private BusinessObject outRelatedObject;
	
	@ManyToOne
	@JoinColumn(name="relation_type_cd",nullable=false)
	private RelationType relationType;

}
