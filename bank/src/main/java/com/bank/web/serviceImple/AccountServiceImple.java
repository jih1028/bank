package com.bank.web.serviceImple;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.web.domain.AccountVO;
import com.bank.web.mapper.AccountMapper;
import com.bank.web.mapper.MemberMapper;
import com.bank.web.service.AccountService;

@Service
public class AccountServiceImple implements AccountService{
	
	AccountVO account;
	@Autowired private SqlSession sqlSession;	
	
	public AccountServiceImple() {
		account = new AccountVO();
		
	}

	@Override
	public String open(String name, int password) {
		// 1. 통장개설
		
		account.setName(name);
		account.setPassword(password);
		
		
		return account.toString();
	}


	@Override
	public String deposit(int money) {
		
		
		int totalMoney = account.getMoney()+money;
		account.setMoney(totalMoney);
		
		// 2. 입금
		return account.toString();
	}

	@Override
	public String withdraw(int money) {
		
		if(account.getMoney() >= money){
			int totalMoney = account.getMoney()-money;
			account.setMoney(totalMoney);
			return account.toString();
		}else{
			return "잔액부족";
		}
		// 3. 출금 ALT+SHIFT+M : 메소드로 추출하는 단축키
		
	}

	@Override
	public String search() {
		// 4. 조회
		return account.toString();
	}
	@Override
	public AccountVO getAccount(String userid) {
		// TODO Auto-generated method stub
		AccountVO temp = new AccountVO();
		 AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
		 temp = mapper.selectAccount(userid);
		return temp;
	}


}
