package com.bank.web.service;

import com.bank.web.domain.AccountVO;

public interface AdminService {
	
	//1. 통장개설
	String open(String name, int password);
	//1. 전체 계좌 수 조회
	public int countAll();
	//2. 계좌번호로 해당 계좌 정보 조회
	public AccountVO searchAccountByAccountNo(int accountNo);
	//3. 이름으로 계좌 정보 조회
	public AccountVO[] searchAccountByName(String name);
	//4. 계좌 삭제(삭제 성공 메시지 보내기)
	public String closeAccount(int accountNo);
	//5. 이름으로 계좌 수 조회( 3번 기능을 수행하기 위해 필요한 메소드)
	public int searchCountByName(String name);
}
