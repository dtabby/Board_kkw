<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>쿼리연습실 몰아보기</title>
	</head>
	<!-- (copy)start -->
	<style>
		table {border: 3px solid black; border-collapse: collapse; width: 800px;}
		th,tr,td {border: 1px solid black;}
		td {text-align: left;}
	</style>
	<!-- (copy)end -->
	<body>
		<h2>쿼리연습실 몰아보기</h2><p>
		<font size="5em" color="green"><b>☞☞ </b></font><a href="${pageContext.request.contextPath}/">리스트로이동</a><br>
		<c:forEach var="list" items="${queryList}" varStatus="status">
		<p>
		● 등록자명 : ${list.userName} ● 수정자아이디 : ${list.updateId}
		<table>
			<tr>
				<td>질문내용</td>
				<td>
					<%-- <c:out value="${list.content}" /> --%>
					<textarea rows="3" cols="90" style="border: none" readonly>
<c:out value="${list.content}"/></textarea>
				</td>
			</tr>
			<tr>
				<td>답변</td>
				<td>
					<textarea rows="7" cols="90" style="border: none" readonly>
<c:out value="${list.contentReply}"/></textarea>
				</td>
			</tr>
		</table>
		<p>
		<hr>
		</c:forEach>
	</body>
</html>