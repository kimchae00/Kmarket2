package kr.co.kmarket2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "km_member_terms")
public class MemberTermsEntity {
	@Id
	private String terms;
	private String privacy;
	private String location;
	private String finance;
	private String tax;
}
