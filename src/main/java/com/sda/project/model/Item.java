package com.sda.project.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


@Entity
@Table(name="ITEM")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_id;
	
	@NotEmpty
	@Size(min=1, max=100)
	@Column(name="TITLE", nullable = false)
	private String title;
	
	@NotEmpty
	@Size(min=1, max=500)
	@Column(name="BODY", nullable = false)
	private String body;
	
	@Enumerated(EnumType.STRING)
	private ItemType type;
	
	@NotNull
	@Range(min=1, max=5)
	@Column(name = "PRIORITY", nullable = false)
	private int priority;
	
	@NotNull
	@Range(min=1, max=3)
	@Column(name = "SEVERITY", nullable = false)
	private int severity;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
//	private List<Tag> tags;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User asignedTo;
	
	
	@Enumerated(EnumType.STRING)
	private ItemState state;
	
	@NotNull
	@Column(name = "ESTIMATE", nullable = false)
	private int originalEstimate;
	
	@NotNull
	@Column(name = "REMAINING", nullable = false)
	private int remainingTime;
	
	@NotNull
	@Column(name = "COMPLETITION", nullable = false)
	private int completitionTime;
	
	
//	discussion*
//	createdBy*
//	modifiedBy*
	
	
}


