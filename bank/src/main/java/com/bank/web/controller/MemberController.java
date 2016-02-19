package com.bank.web.controller;

import java.util.Scanner;

import com.bank.web.domain.MemberBean;
import com.bank.web.service.MemberService;
import com.bank.web.serviceImple.MemberServiceImple;


public class MemberController {
	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		MemberService MemberService = new MemberServiceImple(100);
		while (true) {
			System.out.println("업무선택 : 1.회원가입"
					+"\n2.아이디로 회원정보 검색"
					+"\n3.이름으로 회원정보 검색"
					+"\n4.회원 탈퇴"				
					+"\n5.회원수 확인"				
					+"\n6.로그인"				
					+"\n7.정보수정"				
					+"\n9.종료");

			
			switch (scanner.nextInt()) {
			case 1:
				  MemberBean tempBean = new MemberBean();
				  System.out.println("ID를 입력하세요");
				  tempBean.setUserid(scanner.next());
				  System.out.println("이름을 입력하세요");
				  tempBean.setName(scanner.next());
				  System.out.println("비밀번호을 입력하세요");
				  tempBean.setPassword(scanner.next());
				  System.out.println("주소를 입력하시오");
				  tempBean.setAddr(scanner.next());
				  System.out.println("생년월일을 입력하시오. (예, 19881028)");
				  tempBean.setBirth(scanner.next());


				  System.out.println(MemberService.join(tempBean) );
				  break;
			case 2:
				System.out.println("ID? ");
				System.out.println("ID 정보 : "					+MemberService.searchById(scanner.next()).toString() ) ;
				break;
			case 3:
				System.out.println("이름? ");
				MemberBean[] member = MemberService.searchByName(scanner.next());
				for (int i = 0; i < member.length; i++) {
					System.out.println(member[i]);
				}
				
			break;
			case 4:
				System.out.println("삭제하고 싶은 ID? ");
				System.out.println(MemberService.remove(scanner.next()) ) ;
				break;
			case 5:
				System.out.println("현재 회원수 : " + MemberService.countAll());
				break;
			case 6:
				System.out.println("아이디, 비밀번호를 입력하시오 : " );
				break;
			case 7:
				System.out.println("현재 회원수 : " + MemberService.countAll());
				break;
			case 9:return;
			
			default:
				System.out.println("다시 선택해 주세요");
				break;
			
			}
		}
	}
}
