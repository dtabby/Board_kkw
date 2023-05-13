package com.topia.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.topia.myapp.service.SampleService;
import com.topia.myapp.vo.MemoVO;

@Controller
public class SampleController {

private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	SampleService sampleServ;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome sample! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		// 리스트를 만들어서 모델에 넣습니다.
		List<MemoVO> queryList = sampleServ.queryList(map);
		
		model.addAttribute("queryList", queryList);
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("test", "샘플페이지입니다." );
		
		return "queryList";
	}
}
