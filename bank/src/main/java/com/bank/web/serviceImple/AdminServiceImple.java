package com.bank.web.serviceImple;

import org.springframework.stereotype.Service;

import com.bank.web.domain.AccountVO;
import com.bank.web.service.AdminService;
@Service
public class AdminServiceImple implements AdminService{

	private int count = 0; //멤버변수지만 초기값이 필요한 경우에는 줄 수 있다.

	private AccountVO[] accountList;

	
	public AdminServiceImple(){}
	public AdminServiceImple(int count) {
		accountList = new AccountVO[count];
	}

	@Override
	public String open(String name, int password) {
		// 1. 통장개설
		// account 인스턴스를 필드에 선언하면
		// 나중에 추가되는 값을 오버라이딩 하게 된다.
		// 추가되는 개념으로 코딩하려면 지역변수로 쳐리하고
		// 자료구조를 필드에 선언해야 한다.
		accountList[count] = new AccountVO();
		accountList[count].setName(name);
		accountList[count].setPassword(password);
		
		return accountList[count++].toString();
	}
	
	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return this.getCount();
	}

	@Override
	public AccountVO searchAccountByAccountNo(int accountNo) {
		//2. 계좌번호로 해당 계좌 정보 조회
		AccountVO account = null;
		// 이 라인에서 account 는 인스턴스 개념이 아니라
		// 리턴을 받은 타입의 변수이다.
		for (int i = 0; i < this.getCount(); i++) {
			if(accountList[i].getAccountNo() == accountNo){
				account = accountList[i];
			}
		}
		
		return account;
	}

	@Override
	public AccountVO[] searchAccountByName(String name) {
		//3. 이름으로 계좌 정보 조회
		AccountVO[] tempAccount = null;
		int j=0;
		int tempCount = this.searchCountByName(name);
		AccountVO[] tempList = new AccountVO[tempCount];
		for (int i = 0; i < this.getCount(); i++) {
			if(name.equals(accountList[i].getName())){
				tempList[j] = accountList[i];
				j++;
			}
		}
		
		for (int i = 0; i < tempList.length; i++) {
			System.out.println("테스트로 결과 조회" + tempList[i]);
		}
		
		return tempList;
	}

	@Override
	public String closeAccount(int accountNo) {
		//4. 계좌 삭제(삭제 성공 메시지 보내기)
		//입력한 계좌가 존재하지 않을 경우 if문 처리
		//전체 리스트 count값 줄여줘야댐
		String result ="";
		AccountVO account = null;
		// 이 라인에서 account 는 인스턴스 개념이 아니라
		// 리턴을 받은 타입의 변수이다.
		if(this.searchAccountByAccountNo(accountNo) != null){
			for (int i = 0; i < this.getCount(); i++) {
				if(accountList[i].getAccountNo() == accountNo){
					accountList[i] = accountList[this.getCount()-1];
					accountList[this.getCount()-1] = null;
					this.setCount(getCount()-1);
					result = "삭제성공";
				}
				result = "해당 계좌가 없음";
			}
		} else {
			result = "해당 계좌가 없음";
		}
		
		
		return result;
	}

	@Override
	public int searchCountByName(String name) {
		//5. 이름으로 계좌 수 조회( 3번 기능을 수행하기 위해 필요한 메소드)
		int tempCount = 0;
		for (int i = 0; i < this.getCount(); i++) {
			if(name.equals(accountList[i].getName())){
				tempCount++;
			}
		}
		return tempCount;

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

}
