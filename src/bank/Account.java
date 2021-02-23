package bank;

import java.util.Date;
import java.util.Scanner;

public class Account {
	private String ban, owner;
	private int balance;
	
	Scanner scanner = new Scanner(System.in);
	
	public Account(String ban, String owner, int balance) {
		this.ban = ban;
		this.owner = owner;
		this.balance = balance;
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return " [계좌번호 :" + ban + ", 소유자 명: " + owner + ", 잔액: " + balance + "원]";
	}
	
	//계좌 선택 후 메뉴
	public void choiceMenu() {
		System.out.println("계좌 메뉴 선택");
		System.out.println("1. 입금 2. 출금 3. 잔고확인 4. 거래내역 5. 넘어가기");
		int choice = scanner.nextInt();
		if(choice == 1) {
			deposit();
		}else if(choice == 2) {
			withdraw();
		}else if(choice == 3) {
			findBalance();
		}else if(choice == 4) {
			findBalance();
		}else if(choice==5) {
			return;
		}
		else {
			System.out.println("잘못입력하셨습니다.");
		}
	}
	Date d = new Date();
	//입금
	public void deposit() {
		System.out.print("입금하실 금액을 입력해주세요.");
		int money = scanner.nextInt();
		setBalance(getBalance() + money);
		System.out.println(money + "원 입금하셨습니다.");
		System.out.println("현재 잔액은 " + getBalance() + "원 입니다.");
	}
	//출금
	public void withdraw() {
		System.out.print("출금하실 금액을 입력해주세요.");
		int money = scanner.nextInt();
		if(money > getBalance()) {
			System.out.println("잔액이 부족합니다");
			return;
		}
		setBalance(getBalance() - money);
		System.out.println(money + "원 인출하셨습니다.");
		System.out.println("현재 잔액은 " + getBalance() + "원 입니다.");
	}
	//잔고 확인
	public void findBalance() {
		System.out.println("현재 잔액은 " + getBalance() + "원 입니다.");
	}
	
	//거래 내역
	public void checkDeal() {
		
	}
}
