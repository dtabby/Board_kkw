package com.topia.myapp;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.topia.myapp.service.BoardServiceImpl;
import com.topia.myapp.service.MemoServiceImpl;
import com.topia.myapp.vo.Criteria;
import com.topia.myapp.vo.MemoVO;
import com.topia.myapp.vo.Paging;

/**
 * Handles requests for the application home page.
 */
//@RestController
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// 의존성 주입
	@Autowired
	public BoardServiceImpl bServ;
	@Autowired
	public MemoServiceImpl mServ;
	
	// 등록, 수정 : 작동하는 메서드 1개 + 작동하기 위해 들어가는 메서드 1개 = 2개
	// 조회, 상세, 삭제 : 작동하는 메서드 1개
	// 많이 접해서 자연스럽게 작성할 수 있도록 훈련하기.
	
	// GET/POST 방식을 적어주지 않으면 컨트롤러에서 상황에 맞춰서 알아서 적용이 된다. (GET과 POST 2개를 같이 써야하는 경우도 있기 떄문에 안적어주는 경우도 있음)
	// method = RequestMethod.GET <-- 이런 식으로 적음
	// 컨트롤러와 jsp는 GET/POST 세트로 맞춰야 한다. (컨트롤러가 POST이면 jsp도 POST여야 함)
	// GET은 파라미터 정보가 url에 표시된되고, POST는 body에서 넘어가는 것.
	// @RequestMapping : 화면에 있는 주소를 의미함.
	@RequestMapping(value = "/")
	public ModelAndView home(HttpServletRequest req, Criteria cri) {
		// HttpServletRequest :
		// 화면에서 요청된 정보가 담겨서 온다. (서버 쪽으로 던질 정보가 담긴다)
		// 화면-서버를 연결시키는 용도
		// 일단은 인자값에서 사용하기
		HashMap<String, Object> reqMap = new HashMap<String, Object>();
		// HashMap reqMap : 택배상자라고 생각하기, reqMap(택배상자)에 담아서 DB에 제공함
		ModelAndView mav = new ModelAndView();
		/*
		// 원하는 결과(데이터)를 구하기 위해 디비에 요청 해줌
	    // "boardSearch", boardSearch : 내용물
	    // put : 내용물을 택배상자에 넣음
		reqMap.put("content", content);

//	    String kkwTest = "test입니다. (board01)";
//		mav.addObject("kkwTest", kkwTest);
		*/
		
		// 검색 기능
	    String memoSearch = req.getParameter("memoSearch");
	    String memoWord = req.getParameter("memoWord");
	    
	    reqMap.put("memoSearch", memoSearch);
	    reqMap.put("memoWord", memoWord);
	    // Criteria.java 세팅 값 수동 변경 시 활용 가능
	    // cri.setPerPageNum(10); <-- 이런 식으로 컨트롤러에서 쓰거나 
	    // 혹은, jsp에서도 활용할 수 있다. (<c:url value="./?currentPage=${num}&perPageNum=5"/>)
	    
	    // 페이징 관련 정보 세팅 (Mapper에서 사용, #{criteria.page} <- 이런식으로...)
	    reqMap.put("criteria", cri);
		
		// service와 연결
		List<MemoVO> list = mServ.list(reqMap);
		
		int totalCount = mServ.pagingCount(reqMap);
		System.out.println("HomeController.java || totalCount =========>>>>>>>> " + totalCount);
		
		// 페이징 객체
		Paging paging = new Paging();
		paging.setCri(cri);
		paging.setTotalCount(totalCount);			
		
		
		// List를 ModelAndView에 담음 (화면에 표시하기 위해 사용)
		mav.addObject("list", list);
		mav.addObject("paging", paging);
		// memoSearch와 memoWord를 담는 곳 (home.jsp에서 검색 조건을 설정하고 검색할 경우에 페이징이 풀리지 않게 해준다)
		// <a href='<c:url value="/getBoardList?page=${paging.startPage - 1}}&memoSearch=${search.memoSearch}&memoWord=${search.memoWord}"/>'>◀</a> 이런식으로...
		mav.addObject("search", reqMap);	
		mav.addObject("memoSearch", memoSearch);
		mav.addObject("memoWord", memoWord);
		// 화면과 연결시킴
		mav.setViewName("home");
		return mav;
	}
	
	// 조회 select detail 메서드 
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(HttpServletRequest req, @RequestParam("memoNum") int memoNum) {
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("path =============>>> " + req.getContextPath());

		MemoVO dResult = mServ.detail(memoNum);
		
		mav.addObject("dResult", dResult);
		mav.addObject("path", req.getContextPath());
		mav.setViewName("detail");
		
		return mav;
	}
	
	// 아이디 중복 체크를 실행하는 메서드
	// @ResponseBody : ajax 쓸 때, 반드시 필요함
	@RequestMapping(value = "/checkId")
	public @ResponseBody HashMap<String,Object> checkId(@RequestParam("userId") String userId) {
		
		HashMap<String, Object> resMap = new HashMap<String,Object>();
		int cntResult = mServ.checkId(userId);
		
		////////////응답
		resMap.put("cntResult", cntResult);
	
		return resMap;
	}
	
	// insert문으로 들어가는 메서드
	@RequestMapping(value = "/insert")
	public String insert() {
		logger.info("insert");
		return "insert";
	}
	
	// insert문을 실행하는 메서드
	@RequestMapping(value = "/insertOk")
	// 타입이 String 인 이유 : 컨트롤러에서 페이지 연결할 때, jsp 파일의 이름이 문자열 형식이므로 String으로 해줘야 한다.
	// @RequestParam 문법은 스프링에서만 적용이 가능하다.
	public String insertOk(HttpServletRequest req, @RequestParam("userId") String userId, 
			@RequestParam("userName") String userName, @RequestParam("title") String title, 
			@RequestParam("writeDate") String writeDate, @RequestParam("noticeYN") String noticeYN) {
		
		MemoVO memo = new MemoVO();
		
		// 화면에서 입력받은 정보를 String에 넣음
		// String userName = req.getParameter("userName");
		String content = req.getParameter("content");
		String registId = req.getParameter("userId");
		String registIp = req.getRemoteAddr();
		
		memo.setUserId(userId);
		memo.setUserName(userName);
		memo.setTitle(title);
		memo.setContent(content);
		memo.setNoticeYN(noticeYN);
		memo.setWriteDate(writeDate);
		memo.setRegistId(registId);
		memo.setRegistIp(registIp);
		
		mServ.insert(memo);
		// 단순히 jsp 의 이름을 뜻함
//	    return "home";
		// '/'가 url 맨 뒤에 붙는 것임. ex) "redirect:/detail?userId=" + userId 으로도 쓸 수 있다.
	    return "redirect:/";
	}
	
	//수정 화면으로 이동하는 부분
	@RequestMapping(value = "/update") 
	public String update(Model model, HttpServletRequest req) {
		logger.info("update 페이지 진입");		

		//String userId = "";
		//userId = req.getParameter("userId");
		int memoNum = 0;
		memoNum = Integer.parseInt(req.getParameter("memoNum"));
		MemoVO uResult = mServ.detail(memoNum);
		
		// addObject, addAttribute : 같은 용도임
		model.addAttribute("uResult", uResult);
		
		return "update";
	}
	

	// update문으로 들어가는 메서드
	/*
	@RequestMapping(value = "/update")
	public ModelAndView update(@RequestParam("num") int num) {
		logger.info("update");
		// 상세 페이지에서 수정을 누를 때, 아이디, 이름, 내용을 가져오는 역할 (내가 썼던 내용들)
		ModelAndView mav = new ModelAndView();
		BoardVO uResult = bServ.detail(num);
		
		mav.addObject("uResult", uResult);
		mav.setViewName("update");
		
		return mav;
	}
	*/
	
	// update문을 실행하는 메서드
	@RequestMapping(value = "/updateOk", method = RequestMethod.POST)
	public String updateOk(HttpServletRequest req, @RequestParam("title") String title,
			@RequestParam("content") String content, @RequestParam("contentReply") String contentReply, 
			@RequestParam("writeDate") String writeDate, @RequestParam("noticeYN") String noticeYN, 
			@RequestParam("memoNum") int memoNum) {
		MemoVO memo = new MemoVO();
		
		String registId = req.getParameter("userId");
		
		String updateId = req.getParameter("updateId");
		String updateIp = req.getRemoteAddr();
		
		memo.setMemoNum(memoNum);
		memo.setTitle(title);
		memo.setContent(content);
		memo.setContentReply(contentReply);
		memo.setNoticeYN(noticeYN);
		memo.setWriteDate(writeDate);
		memo.setRegistId(registId);
		memo.setUpdateId(updateId);
		memo.setUpdateIp(updateIp);
		
		mServ.update(memo);
		
		System.out.println("updateIP 테스트용-------------------" + updateIp);
		System.out.println("updateId 테스트용-------------------" + updateId);
		
		return "redirect:/detail?memoNum=" + memoNum;
	}
	
	// (상세페이지)delete문을 실행하는 메서드
	@RequestMapping(value = "/deleteOk", method = RequestMethod.POST)
	public String deleteOk(HttpServletRequest req, @RequestParam("memoNum") int memoNum) {
		
		mServ.delete(memoNum);
		
		return "redirect:/";
	}
	
	// (메인리스트 페이지)리스트에서 체크박스 삭제버튼 클릭시 수행
	// @ResponseBody : ajax 쓸 때, 반드시 필요함
	// HashMap<String, Object> : ajax 쓸 때, 자주 쓰임 (여러 개의 값을 넣을 수 있게 하기 위해...)
	@RequestMapping(value="/listDeleteOk", method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> listDeleteOk(HttpServletRequest request) { 
		
		//String userId = "";
		int memoNum = 0;
		int chkCnt = 0;
		HashMap<String, Object> resMap = new HashMap<String,Object>();
		
		////////////요청
		String chkArr = request.getParameter("checkArr");
		String[] chkArr2 = chkArr.split(",");

		////////////수행
		for(int i = 0; i < chkArr2.length; i++) {
			//userId = chkArr2[i]; // 형변환 필요시 해야 됨
			memoNum = Integer.parseUnsignedInt(chkArr2[i]);
			mServ.delete(memoNum);
			chkCnt = chkCnt+1;
		}
		
		////////////응답
		resMap.put("chkCnt", chkCnt);
		
		return resMap;
	}
}
