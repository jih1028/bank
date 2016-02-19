package com.bank.web.domain;

public class MemberBean {
	private String userid;
	private String name;
	private String password;
	private String addr;
	private String birth;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public String toString() {
		return "userid :"+ userid + ", name :" + name + ", password :" +password+ ", addr :"+ addr +", birth :"+ birth;
	}
	

}
