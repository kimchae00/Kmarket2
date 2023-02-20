package kr.co.kmarket2.vo;

import lombok.Data;

@Data
public class MemberVO {
	public String uid;
	public String pass;
	public String pass1;
	public String pass2;
	public String name;
	public int gender;
	public String hp;
	public String email;
	public int type;
	public String point;
	public int level;
	public String zip;
	public String addr1;
	public String addr2;
	public String company;
	public String ceo;
	public String bizRegNum;
	public String comRegNum;
	public String tel;
	public String manager;
	public String managerHp;
	public String fax;
	public String regip;
	public String wdate;
	public String rdate;
	public int locationTerms;
	
	private String email1;
	private String email2;

	public String getEmail1() {
		int index = email.indexOf("@");
	    return email.substring(0, index);
	}
	
}
