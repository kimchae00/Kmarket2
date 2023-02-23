package kr.co.kmarket2.vo;

import lombok.Data;

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
	public String recipZp;
	public String recipAddr1;
	public String recipAddr2;
	public int ordPayment;
	public int ordComplete;
	public String ordDate;
}
