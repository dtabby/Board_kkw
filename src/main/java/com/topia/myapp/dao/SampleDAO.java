package com.topia.myapp.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topia.myapp.vo.MemoVO;

@Repository
public class SampleDAO {

	@Autowired
	private SqlSessionTemplate tpl;
	
	// 여러 개의 정보가 필요하므로 HashMap<String, Object> map
	public List<MemoVO> list(HashMap<String, Object> map) {
		// 모든 목록 조회
		return tpl.selectList("sample.sampleSelect", map);
	}
}
