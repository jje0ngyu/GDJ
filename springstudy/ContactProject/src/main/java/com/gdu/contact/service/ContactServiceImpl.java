package com.gdu.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.gdu.contact.domain.ContactDTO;
import com.gdu.contact.repository.ContactDAO;

public class ContactServiceImpl implements ContactService {

	
	@Autowired
	private ContactDAO dao;
	
	@Override
	public void findAllContacts(Model model) {
		model.addAttribute("contacts", dao.selectAllContacts());
	}

	@Override
	public ContactDTO findContactByNo(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int savaContact(ContactDTO contact) {
		return dao.insertContact(contact);
	}

	@Override
	public int removeContact(ContactDTO contact) {
		
		return 0;
	}

	@Override
	public int modifycontact(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
