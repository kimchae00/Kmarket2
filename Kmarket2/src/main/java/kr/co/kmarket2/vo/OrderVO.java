package kr.co.kmarket2.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
public class OrderVO {
	
	public int ordNo;
	public String ordUid;
	public int ordCount;
	public int ordPrice;
	public int ordDiscount;
	public int ordDelivery;
	public int savePoint;
	public int usedPoint;
	public int ordTotPrice;
	public String recipName;
	public String recipHp;
	public String recipZip;
	public String recipAddr1;
	public String recipAddr2;
	public int ordPayment;
	public int ordComplete;
	public String ordDate;

	//추가필드
	public String company;
	public String prodName;
	private String thumb1;
	private String thumb2;
	private String thumb3;

}
