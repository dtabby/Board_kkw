
package com.topia.myapp.service;

import java.util.HashMap;
import java.util.List;

import com.topia.myapp.vo.BoardVO;

public interface BoardService {
	// 모든 목록 조회
	public List<BoardVO> list(HashMap<String, Object> map);
	// 하나만 초회
	public BoardVO detail(int num);
	// insert
	public int insert(BoardVO board);
	// update
	public void update(BoardVO board);
	// delete
	public int delete(int num);
}
