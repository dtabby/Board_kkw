<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script src="https://code.jquery.com/jquery-latest.min.js"></script>
		<script src="./resources/js/memo.js" charset="UTF-8"></script>
		<link rel="stylesheet" href="./resources/css/memo.css">
		<!-- 달력 구현 -->
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		
		<title>등록 페이지</title>
		
		<script type="text/javascript">
			// 화면 접근 시 바로 수행되게 하는 부분
			$(window).on("load",function(){
				// 달력 관련 함수 호출
				calendarFunc();
			});
		</script>
	</head>
	<body>
		<form action="./insertOk" method="post" name="insert" id="insert">
			<div class="commonDiv">
				<h1>게시물 등록</h1>
				<%-- <input type="hidden" name="registId" id="registId" value="${registId}"/>
				<input type="hidden" name="registIp" id="registIp" value="${registIp}"/> --%>
				<table>
					<tr class="insertTr">
						<td>
							<!-- 아이디 <input type="text" name="userId" id="userId" required oninput="checkId()"/>
							<span class="idOk"><font color="red">사용 가능한 아이디입니다.</font></span>
							<span class="idAlready"><font color="red">이미 존재하는 아이디입니다.</font></span><br> -->
							<img src="./resources/img/leaf.png"/>
							등록&nbsp;&nbsp;&nbsp;아이디 :
							<input type="text" name="userId" id="userId" maxlength="15"/>
							<font color="purple" size="2px">※ 등록 아이디는 최대 15자까지 입력 가능합니다.</font><br>
							<img src="./resources/img/leaf.png"/>
							등&nbsp;&nbsp;록&nbsp;&nbsp;자&nbsp;&nbsp;명 :
							<input type="text" name="userName" id="userName" maxlength="10"/>
							<font color="purple" size="2px">※ 등록자명은 최대 10자까지 입력 가능합니다.</font><br>
							<img src="./resources/img/leaf.png"/>
							제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목 :
							<input type="text" name="title" id="title" style="width:645px;" placeholder="제목을 입력해주세요. (한글기준 50자 이내)"/><br>
							<img src="./resources/img/leaf.png"/>
							공&nbsp;&nbsp;지&nbsp;&nbsp;여&nbsp;&nbsp;부 :
							<label><input type="radio" id="Y" name="noticeYN" value="Y"/>공지 등록</label>
							<label><input type="radio" id="N" name="noticeYN" value="N" checked="checked"/>공지 해제</label>
							<br>
							<img src="./resources/img/leaf.png"/>
							작&nbsp;&nbsp;성&nbsp;&nbsp;일&nbsp;&nbsp;자 : 
							<input type="text" name="writeDate" id="writeDate" autocomplete="off" readonly="readonly"/><br>
							<img src="./resources/img/leaf.png"/>
							질&nbsp;&nbsp;문&nbsp;&nbsp;내&nbsp;&nbsp;용<br>
							<textarea rows="14" cols="105" name="content" id="content"></textarea><br>
							<input type="button" value="저장" name="insertBtn" id="insertBtn" onclick="insertFunc()"/>
							<input type="button" onclick="location.href='${pageContext.request.contextPath}'" value="뒤로가기"/>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>