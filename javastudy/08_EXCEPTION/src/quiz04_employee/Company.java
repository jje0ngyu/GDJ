package quiz04_employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Company {

	private Employee[] employees;
	private int idx; //* 바늘 가는 데에 실 가 듯이, 배열에는 인덱스!
	private Regular[] regular;
	private Temporary[] temporary;
	private Scanner sc;
	private int totalSalary;
	private int totalPay;
	
	public Company() {
		employees = new Employee[5]; 
		sc = new Scanner(System.in);
	}
	
	public void addEmployee() throws EmployeeException {
		if (idx == employees.length) {
			throw new EmployeeException("FULL", 1);
		}
		System.out.println("1.Regular  2.Temporary");
		int choice = sc.nextInt();
		if (choice < 0 || choice > 2) {
			throw new RuntimeException("정수(1,2)만 입력하세요.");
		}
		
		if (choice == 1) {
			System.out.print("사원 번호를 입력하세요. >>> ");
			int empNo = sc.nextInt();			
			System.out.print("이름을 입력하세요 >>> ");
			String name = sc.next();
			System.out.print("월급을 입력하세요. >>> ");
			int salary = sc.nextInt();
			
			Regular regular = new Regular(empNo, name, salary);
			employees[idx++] = regular;
			
		} else if (choice == 2) {
			System.out.print("사원 번호를 입력하세요. >>> ");
			int empNo = sc.nextInt();
			System.out.print("이름을 입력하세요 >>> ");
			String name = sc.next();
			System.out.print("시급을 입력하세요. >>> ");
			int pay = sc.nextInt();
			System.out.println("근무시간을 입력하세요. >>> ");
			int workTime = sc.nextInt();
			
			Temporary temporary = new Temporary (empNo, name, pay, workTime);
			employees[idx++] = temporary;
		}
		return;
	}
	
	public void droopEmployee() throws EmployeeException {
		if (idx == 0) {
			throw new EmployeeException("EMPTY", 2);
		}
		System.out.println("삭제할 사원번호를 입력하세요. >>> ");
		int empNo = sc.nextInt();
		for (int i = 0; i < idx; i++) {
			if (employees[i].getEmpNo() == empNo) {
				System.arraycopy(employees, i + 1, employees, i, idx - i - 1);
				employees[--idx] = null;
				System.out.println("사원번호가 " + empNo + "인 직원을 삭제하였습니다.");
				return;
			}
		}
		System.out.println("사원번호가 " + empNo + "인 직원은 없습니다.");
		
	}
	
	public void findEmployee() throws EmployeeException {
		if (idx == 0) {
			throw new EmployeeException("EMPTY", 2);
		}
		
		System.out.println("조회할 사원번호를 입력하세요. >>> ");
		int empNo = sc.nextInt();
		for (int i = 0; i < idx; i++) {
			if (empNo == employees[i].getEmpNo()) {
			System.out.println(employees[i]);
			return;
			}
		}
		System.out.println("사원번호가 " + empNo + "인 직원은 없습니다.");
	}
	
	public void printAllEmployees() throws EmployeeException {
		
		// 전체 직원 조회
		if (idx == 0) {
			throw new EmployeeException("EMPTY", 2);
		}
		for (int i = 0; i < idx; i++) {
			System.out.println(employees[i]);
			
		}
		
		// 고용형태별 임금 합계
		
		for (int i = 0; i < regular.length; i++) {
			Regular regSalary = new Regular();
			totalSalary += regSalary.getSalary();
		}
		
		for (int i = 0; i < temporary.length; i++) {
			Temporary temPay = new Temporary();
			totalPay += temPay.getPay();
			
		}

		System.out.println("전체 정규 직원 임금 합계 : " + totalSalary);
		System.out.println("전체 계약 직원 임금 합계 : " + totalPay);
		System.out.println("전 직원 임금 합계 : " + totalSalary + totalPay);
	}

	public void manage() {
		
		while (true) {
			try {
				System.out.print("1.추가  2.삭제  3.조회  4.전체조회  0.종료 >>> ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1 : addEmployee(); break;
				case 2 : droopEmployee(); break;
				case 3 : findEmployee(); break;
				case 4 : printAllEmployees(); break;
				case 0 : System.out.println("프로그램을 종료합니다."); 
					return;
				default : System.out.println("인식할 수 없는 기능입니다.");
				}
			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} finally {
				sc.close();
			}
		}
		
	}
	
}
