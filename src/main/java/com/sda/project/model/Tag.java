package com.sda.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="tag")
public class Tag {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tag_id;

	@Size(min=3, max=10)
	@Column(name = "NAME", nullable = false)
	private String name;
	
	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return tag_id;
	}
}

