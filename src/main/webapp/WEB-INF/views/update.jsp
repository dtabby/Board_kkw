<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
		<title>수정 페이지</title>
		
		<script type="text/javascript">
			// 화면 접근 시 바로 수행되게 하는 부분
			$(window).on("load",function(){
				//달력 관련 함수 호출
				calendarFunc();
			});
		</script>
	</head>
	<body>
		<form action="./updateOk" method="post" name="update" id="update">
			<div class="commonDiv">
				<h1>게시물 수정</h1>
				<input type="hidden" name="updateDate" id="updateDate" value="${uResult.updateDate}"/>
				<input type="hidden" name="registId" id="registId" value="${uResult.registId}"/>
				<input type="hidden" name="updateIp" id="updateIp" value="${uResult.updateIp}"/>
				<input type="hidden" name="userId" id="userId" value="${uResult.userId}"/>
				<input type="hidden" name="memoNum" id="memoNum" value="${uResult.memoNum}"/>
				<table>
					<tr class="updateTr">
						<td>
							<img src="./resources/img/leaf.png"/>
							등록&nbsp;&nbsp;&nbsp;아이디 :
							${uResult.userId}<br>			
							<img src="./resources/img/leaf.png"/>
							등&nbsp;&nbsp;록&nbsp;&nbsp;자&nbsp;&nbsp;명 :
							${uResult.userName}<br>
							<img src="./resources/img/leaf.png"/>
							수정&nbsp;&nbsp;&nbsp;아이디 : 
							<input type="text" name="updateId" id="updateId" maxlength="15" value="${uResult.updateId}"/>
							<font color="purple" size="2px"> ※ 수정 아이디는 최대 15자까지 입력 가능합니다.</font><br>
							<img src="./resources/img/leaf.png"/>
							제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목 : 
							<input type="text" name="title" id="title" value="${uResult.title}" style="width:645px;" placeholder="제목을 입력해주세요. (한글기준 50자 이내)"/><br>
							<img src="./resources/img/leaf.png"/>
							공&nbsp;&nbsp;지&nbsp;&nbsp;여&nbsp;&nbsp;부 :
							<label><input type="radio" id="Y" name="noticeYN" value="Y" <c:if test="${uResult.noticeYN eq 'Y'}">checked</c:if>/>공지 등록</label>
							<label><input type="radio" id="N" name="noticeYN" value="N" <c:if test="${uResult.noticeYN eq 'N'}">checked</c:if>/>공지 해제</label>
							<br>
							<img src="./resources/img/leaf.png"/>
							작&nbsp;&nbsp;성&nbsp;&nbsp;일&nbsp;&nbsp;자 :
							<input type="text" name="writeDate" id="writeDate" autocomplete="off" readonly="readonly" value="${uResult.writeDate}"/><br>
							<img src="./resources/img/leaf.png"/>
							질&nbsp;&nbsp;문&nbsp;&nbsp;내&nbsp;&nbsp;용<br>
							<textarea rows="15" cols="105" name="content" id="content">${uResult.content}</textarea><br>
							<img src="./resources/img/leaf.png"/>
							내&nbsp;&nbsp;용&nbsp;&nbsp;답&nbsp;&nbsp;변<br>
							<textarea rows="30" cols="105" name="contentReply" id="contentReply">${uResult.contentReply}</textarea>
							<br><br>
							<input type="button" value="수정" name="updateBtn" id="updateBtn" onclick="updateFunc()"/>
							<input type="button" onclick="history.back()" value="뒤로가기"/>
							<input type="button" onclick="location.href='${pageContext.request.contextPath}'" value="리스트로"/>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>