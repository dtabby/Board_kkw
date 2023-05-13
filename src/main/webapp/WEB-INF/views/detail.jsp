<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script src="https://code.jquery.com/jquery-latest.min.js"></script>
		<script src="./resources/js/memo.js" charset="UTF-8"></script>
		<link rel="stylesheet" href="./resources/css/memo.css">
		<title>상세 페이지</title>
	</head>
	<body>
		<form action="./deleteOk" method="post" name="delete" id="delete">
			<div class="commonDiv">
				<h1>게시물 상세</h1>
				<input type="hidden" name="memoNum" id="memoNum" value="${dResult.memoNum}"/> 
				<input type="hidden" name="userId" id="userId" value="${dResult.userId}"/>
				<table>
					<tr class="detailTr">
						<td>
							<img src="./resources/img/leaf.png"/>
							등록&nbsp;&nbsp;&nbsp;아이디 :  
							${dResult.userId}<br>
							<img src="./resources/img/leaf.png"/>
							등&nbsp;&nbsp;록&nbsp;&nbsp;자&nbsp;&nbsp;명 : 
							${dResult.userName}<br>
							<img src="./resources/img/leaf.png"/>
							수정&nbsp;&nbsp;&nbsp;아이디 :
							${dResult.updateId}<br>
							<img src="./resources/img/leaf.png"/>
							제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목 : 
							${dResult.title}<br>	
							<img src="./resources/img/leaf.png"/>
							공&nbsp;&nbsp;지&nbsp;&nbsp;여&nbsp;&nbsp;부 : 
							${dResult.noticeYN}<br>
							<img src="./resources/img/leaf.png"/>
							작&nbsp;&nbsp;성&nbsp;&nbsp;일&nbsp;&nbsp;자 :
							${dResult.writeDate}<br>
							<img src="./resources/img/leaf.png"/>
							질&nbsp;&nbsp;문&nbsp;&nbsp;내&nbsp;&nbsp;용<br>
							<textarea rows="15" cols="105" name="content" id="content" readonly="readonly">${dResult.content}</textarea><br>
							<img src="./resources/img/leaf.png"/>
							내&nbsp;&nbsp;용&nbsp;&nbsp;답&nbsp;&nbsp;변<br>
							<textarea rows="30" cols="105" name="contentReply" id="contentReply" readonly="readonly">${dResult.contentReply}</textarea><br><br>
							<input type="button" onclick="location.href='update?memoNum=${dResult.memoNum}'" value="수정페이지로"/>
							<input type="button" onclick="location.href='${path}'" value="리스트로"/>
							<input type="button" value="삭제" name="deleteBtn" id="deleteBtn" onclick="deleteFunc()"/>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>