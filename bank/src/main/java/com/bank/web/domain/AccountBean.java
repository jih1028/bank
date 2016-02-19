package com.bank.web.domain;

public class AccountBean {
	// 멤버필드(멤버변수를 정의한 영역)
	//맴변은 초기화를 하지 않는다. 지변과의 차이점
	//맴변은 매소스 밖에 위치하며 메소드를 사이에서 값을 공유한다.
	public static String Bank = "한빛뱅크";
	private int accountNo;
	private String name;
	private int money;
	private int password;
	private String msg;
	// 멤버메소드 에어리어
	public AccountBean() {
		//4자리 수의 랜덤한 숫자
		//1000이 시작값, 9999는 마지막값
		// 0.0<= Math.random() < 1 
		this.accountNo =  (int) (Math.random() * 9000 ) + 1000 ;
		
		// TODO Auto-generated constructor stub
	}
	//멤변에 값을 입력하고, 조회할 수 있는 메소드인 getter/setter 생성
	//단축키 ALT + SHIFT + S + R
	public int getAccountNo() {
		return accountNo;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "["+ Bank + "]" + this.name + ": " + this.accountNo + "계좌" + "," + "잔고 "+ this.money + "원";
	}
	
	
}
