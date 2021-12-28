package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity

@SuppressWarnings("deprecation")

@Table(name = "AdministratorDetails")
public class Administrator {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int userId;
	@NotEmpty(message = "Username should not be empty")
	private String username;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotEmpty(message = "Password should not be empty")
	private String password;
}
