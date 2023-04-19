package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.ContactDetails;
import com.monocept.service.IContactDetailsService;

@RestController
@RequestMapping("/details")
public class ContactDetailsController {
	
	@Autowired
	private IContactDetailsService service;
	
	@PostMapping("/save-all")
	public List<ContactDetails> saveAll(@RequestBody List<ContactDetails> details){
		return service.saveAll(details);
	}
	
	@PostMapping("/save")
	public ContactDetails save(@RequestBody ContactDetails detail) {
		return service.save(detail);
	}
	
	@GetMapping("/get-all-details")
	public List<ContactDetails> getAllDetails(){
		return service.getAllContactDetails();
	}
}
