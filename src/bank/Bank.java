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
			
			switch(scanner.next()) {
			case "1" : createAccount();
					   break;
			case "2" : findAccountNum();
					   break;
			case "3" : findAccountName();
			           break;
			case "4" : accountList();
			           break;
			case "5" : System.out.println("시스템종료");
					   return;
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
		
		//중복계좌확인
		if(accountArray.size() > 0) {
			for(Account a : accountArray) {
				if(a.getBan().equals(ban)) {
					System.out.println("이미 존재하는 계좌번호입니다.");
					return;
				}
			}
		}
		//입력된 정보로 계좌 객체를 생성하여 등록
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
				
				myAccount.choiceMenu(); //계좌 찾은 후 계좌 메뉴로 이동
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
				
				myAccount.choiceMenu(); //계좌 찾은 후 계좌 메뉴로 이동
			}
		}
		return account;
	}
	
	//계좌목록보기
	public static void accountList() {
		System.out.println("= 전체 계좌 목록 =");
		
		if(accountArray.size() == 0) { //생성한 계좌가 없을 경우
			System.out.println("아직 생성된 계좌가 없습니다.");
			return;
		}
		
		for(int i=0; i<accountArray.size(); i++) {
			Account account = accountArray.get(i);
			
			System.out.println(account);
		}
	}
	
}
