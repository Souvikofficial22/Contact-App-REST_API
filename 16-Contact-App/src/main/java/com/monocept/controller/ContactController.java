package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Contact;
import com.monocept.service.IContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private IContactService service;
	
	@PostMapping("/save-all")
	public List<Contact> saveAll(@RequestBody List<Contact> contacts){
		return service.saveAll(contacts);
	}
	
	@PostMapping("/save")
	public Contact save(@RequestBody Contact contact) {
		return service.save(contact);
	}
	
	@GetMapping("/get-all-contacts")
	public List<Contact> getAllContacts(){
		return service.getAllContacts();
	}
}
