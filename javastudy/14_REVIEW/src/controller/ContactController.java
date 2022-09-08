package controller;

import java.util.Scanner;

import service.ContactService;
import service.ContactServiceImpl;

public class ContactController {
	private Scanner sc;
	private ContactService contactService;
	
	public ContactController() {
		sc = new Scanner(System.in);
		contactService = new ContactServiceImpl();
	}
	
	public void menu() {
		System.out.println("1.연락처 등록");
		System.out.println("2.연락처 수정");
		System.out.println("3.연락처 삭제");
		System.out.println("4.연락처 조회");
		System.out.println("5.전체 연락처");
		System.out.println("0.종료");
	}
	
	public void play() {
		while (true) {
			menu();
			System.out.println("선택 (1~5,0) >>> ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 0:
				return;
			default: System.out.println("다시 선택하세요!");
			}
		}
	}
}
