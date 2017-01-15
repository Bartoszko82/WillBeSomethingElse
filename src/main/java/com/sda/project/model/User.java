package com.sda.project.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="USER")
public class User {

	
	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}
		
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
//	public List<Item> getItemsList() {
//		return itemsList;
//	}
//	
//	public void setItemsList(List<Item> itemsList) {
//		this.itemsList = itemsList;
//	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;

	@NotNull (message = "Login con`t be empty")
	@Size(min=3, max=50)
	@Column(name = "LOGIN", nullable = false)
	private String login;
	
	@NotNull
	@Size(min=3, max=50)
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@NotNull
	@Size(min=3, max=50)
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "asignedTo")
//	private List<Item> itemsList;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + user_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + user_id + ", login=" + login + "]";
	}
	
	
	

}
