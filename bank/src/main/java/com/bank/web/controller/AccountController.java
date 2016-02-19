package com.bank.web.controller;

import java.util.Scanner;

import com.bank.web.service.AccountService;
import com.bank.web.serviceImple.AccountServiceImple;

public class AccountController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AccountService  acc = new AccountServiceImple();
		//AdminService adminService = new AdminServiceImple();
		while (true) {
			System.out.println("업무선택 : 1.계좌개설 2.입금 3.출금 4.잔액조회 5.종료");

			switch (scanner.nextInt()) {
			case 1:
				System.out.println("이름? 비번? ");
				System.out.println(acc.open(scanner.next(), scanner.nextInt()));
				break;
			case 2:
				System.out.println("입금 금액 : ");
				System.out.println(acc.deposit(scanner.nextInt()));
				break;
			case 3:
				System.out.println("출금 금액 : ");
				System.out.println(acc.withdraw(scanner.nextInt()));
				break;
			case 4:
				System.out.println(acc.search());
				break;
			case 5:return;
			
			default:
				System.out.println("1 ~ 5번 사이에서 선택가능합니다.");
				System.out.println("다시 선택해 주세요");
				break;
			
			}

		}
		
	}
}
