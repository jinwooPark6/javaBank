package bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Detail{

	Date d = new Date();
	SimpleDateFormat formatType = new SimpleDateFormat("yyyy년MM월dd일HH시mm분");
	
	private Date dealDay;
	private Date dealTime;
	private String classify;
	private int dealMoney;
	private int balance;
	
	public Detail(Date dealDay, Date dealTime, String classify, int dealMoney, int balance) {
		this.dealDay = dealDay;
		this.dealTime = dealTime;
		this.classify = classify;
		this.dealMoney = dealMoney;
		this.balance = balance;
	}
	
	public Date getDealTime() {
		return dealTime;
	}
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public int getDealMoney() {
		return dealMoney;
	}
	public void setDealMoney(int dealMoney) {
		this.dealMoney = dealMoney;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "[거래금액: "+ dealMoney + "원, " + "잔액: " + balance + "/" + formatType.format(d)+ "]";
	}
	
	
}
