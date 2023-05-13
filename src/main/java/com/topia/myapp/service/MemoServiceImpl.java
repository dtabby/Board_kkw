package com.topia.myapp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topia.myapp.dao.MemoDAO;
import com.topia.myapp.vo.MemoVO;

@Service
public class MemoServiceImpl implements MemoService {
	// 의존성 주입
	@Autowired
	public MemoDAO mDao;
	
	// select 모든 목록 조회
	@Override
	public List<MemoVO> list(HashMap<String, Object> map) {
		List<MemoVO> list = mDao.list(map);
		return list;
	}
	
	// 페이징 총 개수
	@Override
	public int pagingCount(HashMap<String, Object> map) {
		int totalCount = mDao.pagingCount(map);
		return totalCount;
	}

	// 하나만 조회
	@Override
	public MemoVO detail(int memoNum) {
		MemoVO detail = mDao.detail(memoNum);
		return detail;
	}
	
	// insert
	@Override
	public int insert(MemoVO memo) {
		int insert = mDao.insert(memo);
		return insert;
	}
	
	// update
	@Override
	public int update(MemoVO memo) {
		int update = mDao.update(memo);
		return update;
	}
	
	// delete
	@Override
	public int delete(int memoNum) {
		int delete = mDao.delete(memoNum);
		return delete;
	}

	// 아이디 중복 체크
	@Override
	public int checkId(String userId) {
		int checkId = mDao.checkId(userId);
		return checkId;
	}
}
