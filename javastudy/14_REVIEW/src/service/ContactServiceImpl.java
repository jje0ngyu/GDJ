package service;

import java.util.List;

import domain.ContactDTO;
import repository.ContactDAO;

public class ContactServiceImpl implements ContactService {

	private ContactDAO dao = ContactDAO.getInstance();
	
	@Override
	public void addContact(ContactDTO contact) {
		int result = dao.insertContact(contact);
		if (result > 0) {
			System.out.println("연락처가 등록되었습니다.");
		} else {
			System.out.println("연락처 등록이 실패했습니다.");
		}
	}

	@Override
	public void modifyContact(ContactDTO contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteContact(int contact_no) {
		// TODO Auto-generated method stub

	}

	@Override
	public void findContactByNo(int contact_no) {
		// TODO Auto-generated method stub

	}

	@Override
	public void findAllContacts() {
		List<ContactDTO> contacts = dao.selectAllContacts();
		if (contacts.isEmpty()) {
			System.out.println("저장된 연락처가 없습니다.");
		} else {
			for (ContactDTO contact : contacts) {
				System.out.println(contact);
			}
		}

	}

}
