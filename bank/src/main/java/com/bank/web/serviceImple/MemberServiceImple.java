package com.bank.web.serviceImple;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.web.domain.MemberVO;
import com.bank.web.mapper.MemberMapper;
import com.bank.web.service.MemberService;

@Service
public class MemberServiceImple implements MemberService{

	@Autowired MemberVO member;
	private MemberVO[] memberList;
	private Map<String, MemberVO> map;//Map은 인터페이스
	@Autowired private SqlSession sqlSession;	

	public MemberServiceImple(int count) {
		
		memberList = new MemberVO[count];
		map = new HashMap<String,MemberVO>();
	}
	
	public MemberServiceImple() {
	}
//여기서MemberMapper.xml 부른다


		public int join(MemberVO member) {
		// 회원가입

		  MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	      int result = mapper.insertMember(member);

	      return result;
		
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


	public MemberVO searchById(String id) {
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


	public MemberVO[] searchByName(String name) {
		//3. 이름으로 회원 정보 조회
		int j=0;
		MemberVO[] tempList = new MemberVO[searchCountByName(name)];
		for (int i = 0; i < map.size(); i++) {
			if(map.get(i).getName().equals(name) ){
				tempList[j] = map.get(i) ;
				j++;
			}
		}
		
		return tempList;
	}


	public int remove(String userid) {
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	     return mapper.deleteMember(userid);
		
		
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
		
		//return map.remove(id)  != null ? "탈퇴 성공" : "탈퇴 실패";
		
		
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
	   public MemberVO login(MemberVO member) {
	      // 로그인
		  MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	      member = mapper.selectMember(member);

	      return member;
	   }

	@Override
	   public int update(MemberVO member) {
	      // 업데이트
	      //map.replace(member.getUserid(), member);
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);  
		int result = mapper.update(member);

	    return result;
	   }

	@Override
	   public String existCheck(String userid) {
	      // TODO Auto-generated method stub
	     
	         MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	         return mapper.selectUserid(userid);
	   }
	

}
