package com.bank.web.serviceImple;

import java.util.HashMap;
import java.util.Map;

import com.bank.web.domain.MemberBean;
import com.bank.web.service.MemberService;


public class MemberServiceImple implements MemberService{

	private MemberBean member;
	private MemberBean[] memberList;
	private Map<String, MemberBean> map;//Map은 인터페이스
	
	public MemberServiceImple(int count) {
		member = new MemberBean();
		memberList = new MemberBean[count];
		map = new HashMap<String,MemberBean>();
	}
	




	public String join(MemberBean member) {
		// 회원가입

		map.put(member.getUserid(), member);
		return member.getName() + "회원가입을 축하드립니다";
		
		/*
		memberList[count] = new MemberBean();
		memberList[count].setUserid(member.getUserid());
		memberList[count].setName(member.getName());
		memberList[count].setPassword(member.getPassword());
		memberList[count].setAddr(member.getAddr());
		memberList[count].setBirth(member.getBirth());
		
		return memberList[count++].toString();
		
		*/
	}


	public MemberBean searchById(String id) {
		// 아이디로 회원정보 검색
		/*MemberBean member = null;
		for (int i = 0; i < this.getCount(); i++) {
			if(memberList[i].getUserid().equals(id)){
				member = memberList[i];
			}
		}
		
		return member;
		*/
		
		return map.get(id);
		
	}


	public MemberBean[] searchByName(String name) {
		//3. 이름으로 회원 정보 조회
		int j=0;
		MemberBean[] tempList = new MemberBean[searchCountByName(name)];
		for (int i = 0; i < map.size(); i++) {
			if(map.get(i).getName().equals(name) ){
				tempList[j] = map.get(i) ;
				j++;
			}
		}
		
		return tempList;
	}


	public String remove(String id) {
		String result ="";
		/*
		for (int i = 0; i < this.getCount(); i++) {
			if(id.equals(memberList[i].getUserid()) ){
				memberList[i] = memberList[this.getCount()-1];
				memberList[this.getCount()-1] = null;
				this.setCount(getCount()-1);
				result = "삭제성공";
			}
			else{
				result = "해당 멤버 없음";
		
			}
		}	
		return result;*/
		
		return map.remove(id)  != null ? "탈퇴 성공" : "탈퇴 실패";
		
		
	}


	public int countAll() {
		//전체 멤버수 조회
		return map.size();
	}


	public int searchCountByName(String name) {
		// 이름으로 아이디 수 조회( 3번 기능을 수행하기 위해 필요한 메소드)
		int tempCount = 0;
		for (int i = 0; i < map.size(); i++) {
			if(name.equals(memberList[i].getName())){
				tempCount++;
			}
		}
		return tempCount;
	}


	
	@Override
	public String login(String id, String pass) {
		// 로그인
		String result ="로그인 실패";
		//메소드 체인 기법

		if (map.containsKey(id)) { //맵에 id가 존재하는지를 먼저 체크한다.
			result = (map.get(id)).getPassword().equals(pass) ? "로그인 성공" : "비밀번호가 일치하지 않습니다.";
				
		} else {
			result = "아이디가 존재하지 않거나, 잘못된 아이디 입니다.";
		}
		
		
		return result;
	}

	@Override
	public String update(MemberBean member) {
		// 정보수정
		
		String result = "업데이트 실패";
		map.replace(member.getUserid(), member);
		
		/*
		for (int i = 0; i < map.size(); i++) {
			(map.get(i)).setName(member.getName());
			(map.get(i)).setUserid(member.getUserid());
			(map.get(i)).setPassword(member.getPassword());
			(map.get(i)).setAddr(member.getAddr());
			(map.get(i)).setBirth(member.getBirth());		
		}
		*/
		return "업데이트 성공";
	}

}
