package bank;

import java.util.ArrayList;
import java.util.Scanner;


public class Bank {
	private static ArrayList<Account> accountArray = new ArrayList<Account>();
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
	
		while(true) {
			System.out.println("-------------Java Bank-------------");
			System.out.println("전체 계좌 수 : " + accountArray.size());
			System.out.println("1.계좌생성 2.계좌찾기(계좌번호) 3.계좌찾기(계좌주명) 4.계좌목록보기 5.종료");
			System.out.println("-----------------------------------");
			System.out.print("메뉴를 선택해주세요: ");
			
			int choice = scanner.nextInt();
			if(choice == 1) {
				createAccount();
			}else if(choice == 2) {
				findAccountNum();
			}else if(choice == 3) {
				findAccountName();
			}else if(choice == 4) {
				accountList();
			}else if(choice == 5) {
				System.out.println("시스템 종료.");
				break;
			}else {
				System.out.println("잘못입력하셨습니다!");
			}
		}
		
	}
	
	
	//계좌 생성
	public static void createAccount() {
		System.out.println("-----계좌생성-----");
		System.out.print("계좌번호: ");
		String ban = scanner.next();
		System.out.print("계좌주: ");
		String owner = scanner.next();
		System.out.print("최초입금액: ");
		int balance = scanner.nextInt();
		Account newAccount = new Account(ban, owner, balance);
		accountArray.add(newAccount);
		System.out.println("계좌가 생성되었습니다!");
		
	}
	//계좌찾기(계좌번호)
	public static Account findAccountNum() {
		Account account = null;
		System.out.print("찾으실 계좌의 계좌번호를 입력해주세요: ");
		String myBan = scanner.next();
		for(int i = 0; i<accountArray.size();i++) {
			if(myBan.equals(accountArray.get(i).getBan())) {
				Account myAccount = accountArray.get(i);
				System.out.println("=해당 계좌번호의 계좌정보=");
				System.out.println(myAccount);
				myAccount.choiceMenu();
			}
		}
		return account;
	}
	//계좌찾기(이름)
	public static Account findAccountName() {
		Account account = null;
		System.out.print("찾으실 계좌의 소유주명을 입력해주세요: ");
		String myOwner = scanner.next();
		for(int i = 0; i<accountArray.size();i++) {
			if(myOwner.equals(accountArray.get(i).getOwner())) {
				Account myAccount = accountArray.get(i);
				System.out.println("=해당 소유자명의 계좌정보=");
				System.out.println(myAccount);
				myAccount.choiceMenu();
			}
		}
		return account;
	}
	//계좌목록보기
	public static void accountList() {
		System.out.println("= 전체 계좌 목록 =");
		if(accountArray.size() == 0) {
			System.out.println("아직 생성된 계좌가 없습니다.");
			return;
		}
		for(int i=0; i<accountArray.size(); i++) {
			Account account = accountArray.get(i);
			System.out.println(account);
		}
		
		
	}
	
	
	
}
