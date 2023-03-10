package kr.co.kmarket2.vo;

import lombok.Data;

@Data
public class CartVO {
	private int cartNo;
	private String uid;
	private int prodNo;
	private int count;
	private int price;
	private int discount;
	private int point;
	private int delivery;
	private int total;
	private String rdate;
	private String prodName;
	private String thumb1;
	private String descript;
	private int prodCate1;
	private int prodCate2;

}
