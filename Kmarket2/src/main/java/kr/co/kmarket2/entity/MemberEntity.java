package kr.co.kmarket2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "km_member")
public class MemberEntity {
	@Id
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
}
