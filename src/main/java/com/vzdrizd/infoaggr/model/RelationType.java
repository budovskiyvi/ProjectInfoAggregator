/**
 * 
 */
package com.vzdrizd.infoaggr.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "relation_type")
public class RelationType implements Serializable{

	@Id
    @Column(name = "relation_type_cd")
	private String code;
	
	@Column(name = "inName")
	private String inName;
	
	@Column(name = "outName")
	private String outName;
}
