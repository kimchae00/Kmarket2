package kr.co.kmarket2.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductVO {
	
	private int prodNo;
	private int prodCate1;
	private int prodCate2;
	private String prodName;
	private String descript;
	private String company;
	private String seller;
	private int price;
	private int discount;
	private int point;
	private int stock;
	private int sold;
	private int delivery;
	private int hit;
	private int score;
	private int review;
	private String thumb1;
	private String thumb2;
	private String thumb3;
	private String detail;
	private MultipartFile filethumb1;
	private MultipartFile filethumb2;
	private MultipartFile filethumb3;
	private MultipartFile filedetail;
	private String status;
	private String duty;
	private String receipt;
	private String bizType;
	private String origin;
	private String ip;
	private String rdate;
	private int disprice;
}
