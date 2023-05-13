package com.topia.myapp.vo;

public class Criteria {
	
	// 특정 페이지 조회를 위한 클래스
	private int page; 		// 현재 페이지 번호
	private int perPageNum; // 페이지당 보여줄 게시글의 개수
	
	public int getPageStart() {
		// 특정 페이지의 범위를 정하는 구간, 현재 페이지의 게시글 시작 번호
		// 0 ~ 10에서 0에 해당, 10 ~ 20에서 10에 해당, 이런 식으로...
		return (this.page - 1) * perPageNum;
	}

	public Criteria() {
		// 기본 생성자 : 최초 게시판에 진입시 필요한 기본값
		this.page = 1;
		this.perPageNum = 10;	// 몇 페이지까지 표시할 지 설정
//		this.perPageNum = 2;	// 테스트용
	}

	// 현재 페이지 번호 page : getter, setter
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			
		} else {
			this.page = page;
		}	
	}

	
	// 페이지당 보여줄 게시글의 개수 perPageNum : getter, setter
	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		int cnt = this.perPageNum;
		
		// 없어도 되는 부분,
		// 여기서 수정할 필요 없이, 컨트롤러나 jsp에서 개발자가 직접 값을 세팅할 수 있도록 하기 위해 적어준 것.
		if(perPageNum != cnt) {
			this.perPageNum = cnt;	
		} else {
			this.perPageNum = perPageNum;
		}
		
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
}