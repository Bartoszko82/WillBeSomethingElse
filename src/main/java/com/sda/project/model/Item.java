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

	public int getItemId() {
		return item_id;
	}

	public void setItemId(int item_id) {
		this.item_id = item_id;
	}

	public String getState() {
	return state;
	}	

	public void setState(String state) {
	this.state = state;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

//	public User getAsignedTo() {
//		return asignedTo;
//	}
//
//	public void setAsignedTo(User asignedTo) {
//		this.asignedTo = asignedTo;
//	}



	public int getOriginalEstimate() {
		return originalEstimate;
	}

	public void setOriginalEstimate(int originalEstimate) {
		this.originalEstimate = originalEstimate;
	}

	public int getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}

	public int getCompletitionTime() {
		return completitionTime;
	}

	public void setCompletitionTime(int completitionTime) {
		this.completitionTime = completitionTime;
	}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_id;
	
	@NotEmpty
	@Size(min=1, max=100)
	@Column(name="TITLE", nullable = false)
	private String title;
	
	@NotEmpty (message = "body can`t be empty")
	@Size(min=1, max=500)
	@Column(name="BODY", nullable = false)
	private String body;
	
//	@Enumerated(EnumType.STRING)
	@Column(name = "ITEM_TYPE", nullable = false)
	private String type;
	
//	@Enumerated(EnumType.STRING)
	@Column(name = "ITEM_STATE", nullable = false)
	private String state;
	
//	@NotNull
//	@Range(min=1, max=5)
	@Column(name = "PRIORITY", nullable = false)
	private int priority;
	
//	@NotNull
	@Range(min=1, max=3)
	@Column(name = "SEVERITY", nullable = false)
	private int severity;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
//	private List<Tag> tags;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "USER_ID", nullable = false)
//	private User asignedTo;
	
	@Column(name = "ESTIMATE", nullable = false)
	private int originalEstimate;
	
	@Column(name = "REMAINING", nullable = false)
	private int remainingTime;

	@Column(name = "COMPLETITION", nullable = false)
	private int completitionTime;
	
	
//	discussion*
//	createdBy*
//	modifiedBy*
	

	
}


