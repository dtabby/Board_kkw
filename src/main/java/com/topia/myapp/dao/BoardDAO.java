package com.topia.myapp.dao;

import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topia.myapp.vo.BoardVO;

@Repository
public class BoardDAO {
	//의존성 주입
	@Autowired
	private SqlSessionTemplate tpl;
	
	// 여러 개의 정보를 담은 여러개의 리스트 목록을 출력하므로(여러 번 수행하므로) List<BoardVO>
	// 여러 개의 정보가 필요하므로 HashMap<String, Object> map
	public List<BoardVO> list(HashMap<String, Object> map) {
		// 모든 목록 조회
		return tpl.selectList("board.boardSelect", map);
	}
	
	// 여러 개의 정보를 담으므로 BoardVO
	// detail 페이지를 조회하기 위해 필요한 정보는 num 하나이므로 int num
	public BoardVO detail(int num) {
		// 하나만 조회
		return tpl.selectOne("board.boardDetailSelect", num);
	}
	
	// insert는 한 번 수행하므로 int (void도 괜찮음, int로 한건 나중에 몇 번 실행했는지 체크하기 위해)
	// 여러개의 정보들이 필요하므로 BoardVO board
	public int insert(BoardVO board) {
		// insert
		return tpl.insert("board.boardInsert", board);
	}
	
	// update는 한 번 수행하므로 int (void도 괜찮음, int로 한건 나중에 몇 번 실행했는지 체크하기 위해)
	// 여러개의 정보들이 필요하므로 BoardVO board
	public void update(BoardVO board) {
		// update
		tpl.update("board.boardUpdate", board);
	}
	
	// delete는 한 번 수행하므로 int (void도 괜찮음, int로 한건 나중에 몇 번 실행했는지 체크하기 위해)
	// delete 기능을 수행하기 위해 필요한 정보는 num 하나이므로 int num
	public int delete(int num) {
		// delete
		return tpl.delete("board.boardDelete", num);
	}
}
