package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.ContactDetails;
import com.monocept.repository.ContactDetailsRepository;

@Service
public class ContactDetailsServiceImpl implements IContactDetailsService {

	@Autowired
	private ContactDetailsRepository detailsRepo; 
	
	@Override
	public List<ContactDetails> saveAll(List<ContactDetails> contactDetails) {
		
		return detailsRepo.saveAll(contactDetails);
	}

	@Override
	public ContactDetails save(ContactDetails contactDetails) {
		return detailsRepo.save(contactDetails);
	}

	@Override
	public List<ContactDetails> getAllContactDetails() {
		return detailsRepo.findAll();
	}

}
