package com.mpattt.domain.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_roles")
public class UserRole {
	@Id
	@Column(nullable = false, unique = true)
	private int user_id;

	private int role_id;

	public int getId() {
		return user_id;
	}

	public void setId(int id) {
		this.user_id = id;
	}

	public int getRole() {
		return role_id;
	}

	public void setRole(int role) {
		this.role_id = role;
	}
}
