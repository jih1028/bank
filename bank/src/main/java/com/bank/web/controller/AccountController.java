package com.bank.web.controller;

import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.web.domain.AccountVO;
import com.bank.web.domain.MemberVO;
import com.bank.web.service.AccountService;
import com.bank.web.service.AdminService;
import com.bank.web.serviceImple.AccountServiceImple;


@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired AccountServiceImple accountService;
	//내 계좌페이지 이동
   @RequestMapping(value = "/myAccount/{userid}", method = RequestMethod.GET)
   public String myAccount(Model model, 
		   @PathVariable("userid")String userid,
		   HttpSession session) {
	   
 
      AccountVO acc = new AccountVO();
   
      acc = accountService.getAccount(userid);
      System.out.println("내 계좌정보  : "+ acc.getAccountNo());
      System.out.println("내 계좌 잔액 : "+ acc.getMoney());
      System.out.println("내 계좌 비번 : "+ acc.getPassword());
      
      

      model.addAttribute("account", acc);
      
      return "account/myAccount";
   }
   //계좌 개설하기
   @RequestMapping(value = "/openAccount", method = RequestMethod.GET)
   public String openAccount(Model model, HttpSession session) {
      MemberVO temp = new MemberVO();
      temp = (MemberVO) session.getAttribute("member");
      model.addAttribute("message", temp.getName());
      model.addAttribute("userid", temp.getUserid());
      
      return "account/myAccount";
   }
   
   //입금하기
   @RequestMapping(value = "/deposit", method = RequestMethod.GET)
   public String deposit(Model model, HttpSession session) {
      MemberVO temp = new MemberVO();
      temp = (MemberVO) session.getAttribute("member");
      model.addAttribute("message", temp.getName());
      model.addAttribute("userid", temp.getUserid());
      
      return "account/myAccount";
   }
   
   //출금하기
   @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
   public String withdraw(Model model, HttpSession session) {
      MemberVO temp = new MemberVO();
      temp = (MemberVO) session.getAttribute("member");
      model.addAttribute("message", temp.getName());
      model.addAttribute("userid", temp.getUserid());
      
      return "account/myAccount";
   }
   
   //계좌해지
   @RequestMapping(value = "/removeAccount", method = RequestMethod.GET)
   public String removeAccount(Model model, HttpSession session) {
      MemberVO temp = new MemberVO();
      temp = (MemberVO) session.getAttribute("member");
      model.addAttribute("message", temp.getName());
      model.addAttribute("userid", temp.getUserid());
      
      return "account/myAccount";
   }
}