package kr.co.kmarket2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="km_terms_policy")
public class TemrsPolicyEntity {
	@Id
	private String buyer;
	private String seller;
	private String finance;
	private String location;
	private String privacy;

}
