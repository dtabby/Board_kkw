package com.topia.myapp.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topia.myapp.vo.MemoVO;

@Repository
public class MemoDAO {
	//의존성 주입
	@Autowired
	private SqlSessionTemplate tpl;
	
	// 여러 개의 정보를 담은 여러개의 리스트 목록을 출력하므로(여러 번 수행하므로) List<MemoVO>
	// 여러 개의 정보가 필요하므로 HashMap<String, Object> map
	public List<MemoVO> list(HashMap<String, Object> map) {
		// 모든 목록 조회
		return tpl.selectList("memo.memoSelect", map);
	}
	
	// 페이징 처리(총갯수)
	public int pagingCount(HashMap<String, Object> map) {
		return tpl.selectOne("memo.memoPagingCount", map);
	}

	// 여러 개의 정보를 담으므로 MemoVO
	// detail 페이지를 조회하기 위해 필요한 정보는 userId 하나이므로 String userId	
	public MemoVO detail(int memoNum) {
		// 하나만 조회
		return tpl.selectOne("memo.memoDetailSelect", memoNum);
	}
	
	// insert는 한 번 수행하므로 int (void도 괜찮음, int로 한건 나중에 몇 번 실행했는지 체크하기 위해)
	// 여러개의 정보들이 필요하므로 MemoVO memo
	// 인자값으로 전달하기 위해서 MemoVO memo를 적어줌.
	public int insert(MemoVO memo) {
		return tpl.insert("memo.memoInsert", memo);
	}
	
	// update는 한 번 수행하므로 int (void도 괜찮음, int로 한건 나중에 몇 번 실행했는지 체크하기 위해)
	// 여러개의 정보들이 필요하므로 MemoVO memo
	public int update(MemoVO memo) {
		return tpl.update("memo.memoUpdate", memo);
	}
	
	// delete는 한 번 수행하므로 int (void도 괜찮음, int로 한건 나중에 몇 번 실행했는지 체크하기 위해)
	// delete 기능을 수행하기 위해 필요한 정보는 userId 하나이므로 String userId
	public int delete(int memoNum) {
		return tpl.delete("memo.memoDelete", memoNum);
	}
	
	// 중복되는 userId 값을 체크하기 위한 메서드
	public int checkId(String userId) {
		return tpl.selectOne("memo.memoCheckId", userId);
	}
}
