package com.monocept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.entity.ContactDetails;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Integer>{

}
