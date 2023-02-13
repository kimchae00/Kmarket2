package kr.co.kmarket2.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ArticleVO {

	public int no;
	public int parent;
	public int comment;
	public String group;
	public String cate;
	public String cate2;
	public String title;
	public String content;
	public int file;
	public int hit;
	public String uid;
	public String regip;
	public String rdate;
	
}
