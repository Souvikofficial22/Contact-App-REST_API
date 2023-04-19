package com.monocept.service;

import java.util.List;

import com.monocept.entity.*;

public interface IContactDetailsService {

	public List<ContactDetails> saveAll(List<ContactDetails> contactDetails);
	public ContactDetails save(ContactDetails contactDetails);
	public List<ContactDetails> getAllContactDetails();
}
