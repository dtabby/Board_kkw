package com.topia.myapp.vo;

public class BoardVO {
	// 컬럼에 대한 정보들을 담고 있음
	private int num;			// 번호
	private String id;			// 아이디
	private String name;		// 이름
	private String content;		// 내용
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
