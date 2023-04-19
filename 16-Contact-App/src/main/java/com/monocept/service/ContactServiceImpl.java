package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Contact;
import com.monocept.repository.ContactRepository;

@Service
public class ContactServiceImpl implements IContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	@Override
	public List<Contact> saveAll(List<Contact> contacts) {

		return contactRepo.saveAll(contacts);
	}

	@Override
	public Contact save(Contact contact) {
		return contactRepo.save(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepo.findAll();
	}
	
}
