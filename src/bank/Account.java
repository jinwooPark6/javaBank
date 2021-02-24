package bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Account {
	
	private String ban, owner;
	private int balance;
	private ArrayList<Detail> detailList = new ArrayList<>();
	
	Date d = new Date();
	Scanner scanner = new Scanner(System.in);
	
	public Account(String ban, String owner, int balance) {
		this.ban = ban;
		this.owner = owner;
		this.balance = balance;
	}

	public String getBan() { return ban; }
	public void setBan(String ban) { this.ban = ban; }
	public String getOwner() { return owner; }
	public void setOwner(String owner) { this.owner = owner; }
	public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }

	@Override
	public String toString() {
		return " [계좌번호 :" + ban + ", 소유자 명: " + owner + ", 잔액: " + balance + "원]";
	}
	
	//계좌 선택 후 메뉴
	public void choiceMenu() {
		System.out.println("계좌 메뉴 선택: ");
		System.out.println("1. 입금 2. 출금 3. 잔고확인 4. 거래내역 5. 홈돌아가기");
		
		switch(scanner.next()) {
		
		case "1" : deposit();
				   break;
		case "2" : withdraw();
		           break;
		case "3" : findBalance();
		           break;
		case "4" : checkDeal();
		           break;
		case "5" : return;
		}
	}
	
	//입금
	public void deposit() {
		System.out.print("입금하실 금액을 입력해주세요: ");
		
		int money = scanner.nextInt();
		setBalance(getBalance() + money);
		
		System.out.println(money + "원 입금하셨습니다.");
		System.out.println("현재 잔액은 " + getBalance() + "원 입니다.");
		
		Detail newDtail = new Detail(d, "입금", money, getBalance()); //입금거래내역등록
		detailList.add(newDtail);
	}
	//출금
	public void withdraw() {
		System.out.print("출금하실 금액을 입력해주세요: ");
		
		int money = scanner.nextInt();
		
		if(money > getBalance()) { //현재 가진 돈이 출금액보다 부족할 경우
			System.out.println("잔액이 부족합니다");
			return;
		}
		
		setBalance(getBalance() - money);
		
		System.out.println(money + "원 인출하셨습니다.");
		System.out.println("현재 잔액은 " + getBalance() + "원 입니다.");
		
		Detail newDtail = new Detail(d, "인출", money, getBalance()); //출금거래내역등록
		detailList.add(newDtail);
	}
	
	//잔고 확인
	public void findBalance() {
		System.out.println("현재 잔액은 " + getBalance() + "원 입니다.");
	}
	
	//거래 내역
	public void checkDeal() {
		System.out.println("= 거래 내역 =");
		
		if(detailList.size() == 0) { //아직 입,출금 내역이 없을 경우
			System.out.println("아직 거래한 내역이 없습니다.");
			return;
		}
		
		for(int i=0; i<detailList.size(); i++) {
			Detail detail = detailList.get(i);
			System.out.println(detail);
		}
	}
}
