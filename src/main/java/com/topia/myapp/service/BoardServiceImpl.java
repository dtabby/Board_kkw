package com.topia.myapp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topia.myapp.dao.BoardDAO;
import com.topia.myapp.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	// 의존성 주입
	@Autowired
	public BoardDAO bDao;
	
	// select 모든 목록 조회
	@Override
	public List<BoardVO> list(HashMap<String, Object> map) {
		List<BoardVO> list = bDao.list(map);
		return list;
	}

	// 하나만 조회
	@Override
	public BoardVO detail(int num) {
		BoardVO detail = bDao.detail(num);
		return detail;
	}

	// insert
	@Override
	public int insert(BoardVO board) {
		int insert = bDao.insert(board);
		return insert;
	}
	
	// update
	@Override
	public void update(BoardVO board) {
		bDao.update(board);
	}

	// delete
	@Override
	public int delete(int num) {
		int delete = bDao.delete(num);
		return delete;
	}
}
