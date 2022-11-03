package com.gdu.contact.service;

import org.springframework.ui.Model;

import com.gdu.contact.domain.ContactDTO;

public interface ContactService {

	public void findAllContacts(Model model);
	public ContactDTO findContactByNo(int no); 
	public int savaContact(ContactDTO contact);
	public int removeContact(ContactDTO contact);
	public int modifycontact(int no);
}
