package com.monocept.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	public User() {
		
	}
	
	public User(int userId, String firstName, String lastName, boolean isAdmin, boolean isActive,
			List<Contact> contacts) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
		this.contacts = contacts;
	}

	@Column(columnDefinition = "boolean default true")
	private boolean isAdmin;
	
	@Column(columnDefinition = "boolean default true")
	private boolean isActive;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_user_id",referencedColumnName = "user_id")
	private List<Contact> contacts;
}
