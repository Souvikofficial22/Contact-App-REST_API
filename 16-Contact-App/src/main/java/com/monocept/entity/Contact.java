package com.monocept.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="contact_id")
	private int contactId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name",nullable=false)
	private String lastName;
	
	@Column(columnDefinition = "boolean default true")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="fk_user_id")
	private User users;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_contact_id",referencedColumnName = "contact_id")
	private List<ContactDetails> contactDetails;

	public Contact(int contactId, String firstName, String lastName, boolean isActive, User users,
			List<ContactDetails> contactDetails) {
		super();
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
		this.users = users;
		this.contactDetails = contactDetails;
	}

	public Contact() {
		super();
	}
	
	
	
}
