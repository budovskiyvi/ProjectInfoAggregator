/**
 * 
 */
package com.vzdrizd.infoaggr.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "document")
public class Document {
	
	@Id
    @Column(name = "document_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "document_type")
	private DocumentType documentType;
}
