package com.topia.myapp.service;

import java.util.HashMap;
import java.util.List;

import com.topia.myapp.vo.MemoVO;

public interface MemoService {
	// 모든 목록 조회
	public List<MemoVO> list(HashMap<String, Object> map);
	// 페이징(총갯수)
	public int pagingCount(HashMap<String, Object> map);
	// 하나만 초회
	public MemoVO detail(int memoNum);
	// insert
	public int insert(MemoVO memo);
	// update
	public int update(MemoVO memo);
	// delete
	public int delete(int memoNum);
	// 아이디 중복 체크
	public int checkId(String userId);
}
