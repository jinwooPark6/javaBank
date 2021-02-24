package bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Detail{

	Date d = new Date();
	SimpleDateFormat formatType = new SimpleDateFormat("yyyy년MM월dd일HH시mm분");
	
	private Date dealTime; //거래일
	private String classify; //입출금구분
	private int dealMoney; //거래금액
	private int balance; //잔고
	
	public Detail(Date dealTime, String classify, int dealMoney, int balance) {
		this.dealTime = dealTime;
		this.classify = classify;
		this.dealMoney = dealMoney;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "[거래금액: "+ dealMoney + "원" + ", 구분:" + classify + ", 잔액:" + balance + "원 /" + formatType.format(d)+ "]";
	}
}
