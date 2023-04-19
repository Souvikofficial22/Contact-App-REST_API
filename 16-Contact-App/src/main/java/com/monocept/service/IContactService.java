package com.monocept.service;

import java.util.List;

import com.monocept.entity.Contact;

public interface IContactService {
	
	public List<Contact> saveAll(List<Contact> contacts);
	public Contact save(Contact contacts);
	public List<Contact> getAllContacts();
}
