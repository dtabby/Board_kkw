package com.topia.myapp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topia.myapp.dao.SampleDAO;
import com.topia.myapp.vo.MemoVO;

@Service
public class SampleServiceImpl implements SampleService {

		// 의존성 주입
		@Autowired
		public SampleDAO sDao;
		
		// select 모든 목록 조회
		@Override
		public List<MemoVO> queryList(HashMap<String, Object> map) {
			List<MemoVO> list = sDao.list(map);
			return list;
		}
}
