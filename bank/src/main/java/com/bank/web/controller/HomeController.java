package com.bank.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.web.domain.MemberVO;
import com.bank.web.service.MemberService;
import com.bank.web.serviceImple.MemberServiceImple;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   @Autowired MemberVO member;
   
   @Autowired MemberServiceImple service;
   
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
      logger.info("Welcome home! The client locale is {}.", locale);
      
      
      member.setUserid("kim");
      member.setPassword("1");
      member=service.login(member);
      System.out.println("로그인 후 이름: " +member.getName());
      model.addAttribute("name",member.getName());
      
      return "global/home";
   }
   
}