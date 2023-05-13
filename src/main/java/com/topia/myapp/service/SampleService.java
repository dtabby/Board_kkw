package com.topia.myapp.service;

import java.util.HashMap;
import java.util.List;

import com.topia.myapp.vo.MemoVO;

public interface SampleService {

	//샘플페이지
	public List<MemoVO> queryList(HashMap<String, Object> map); 
}
