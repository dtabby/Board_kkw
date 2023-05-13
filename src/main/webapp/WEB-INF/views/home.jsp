<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<script src="https://code.jquery.com/jquery-latest.min.js"></script>
		<script src="./resources/js/memo.js"></script>
		<link rel="stylesheet" href="./resources/css/memo.css">
		<script>
			/* 페이징 부분 */
			$(document).ready(function() {
				
				// 체크박스 삭제 관련 함수 호출
				checkBoxFunc();
				
				/* 방식변경으로 주석처리(지우진 말아보세요) 
				var listForm = $("#search");
				$(".pagination_button a").on("click", function(e) {
					e.preventDefault();
					
					listForm.find("input[name='currentPage']").val($(this).attr("href"));
					listForm.submit();
				});
				 */
			});
			
			function getAllData() {
			    location.href = "${pageContext.request.contextPath}/queryList";
			}
		</script>
	
		<title>초간단 게시판의 시작</title>
	</head>
	<body>
		<!-- 상대경로 최상위 루트임 ./ -->
		<form action="./" method="post" name="search" id="search">
			<%-- <input type="hidden" name="currentPage" id="currentPage" value="${criteria.currentPage}"/> --%>
			<h1><a class="h1" href="https://www.naver.com">메모게시판 목록<%--  ${kkwTest} --%></a></h1>
			<select id="memoSearch" name="memoSearch">
				<!-- selected : selected="selected"를 의미한다. -->
				<option value="" <c:if test="${memoSearch eq ''}">selected</c:if>>검색조건</option>
				<option value="memoTitle" <c:if test="${memoSearch eq 'memoTitle'}">selected</c:if>>제목</option>
				<option value="memoContent" <c:if test="${memoSearch eq 'memoContent'}">selected</c:if>>내용</option>
				<option value="memoName" <c:if test="${memoSearch eq 'memoName'}">selected</c:if>>등록자명</option>
				<option value="memoRegistId" <c:if test="${memoSearch eq 'memoRegistId'}">selected</c:if>>등록아이디</option>
			</select>
			<input type="text" name="memoWord" id="memoWord" value="${memoWord}"/> 
			<input type="button" value="검색" name="searchBtn" id="searchBtn" onclick="searchFunc()"/>
			<input type="button" value="등록" name="insertBtn" id="insertBtn" onclick="location.href='insert'"/>
			<input type="button" value="삭제" name="deleteBtn" id="deleteBtn" onclick="checkDelFunc()"/>
			<input type="button" value="결과몰아보기" name="allBtn" id="allBtn" onclick="getAllData()"/>
			<br><br>
			<table>
				<thead>
					<tr>
						<th><input type="checkbox" id="checkAll" name="checkAll"/></th>
						<th>순번</th>
						<!-- <th>아이디</th> -->
						<th>제목</th>
						<th>내용</th>
						<th>작성일자</th>
						<th>등록일자</th>
						<th>수정일자</th>
						<th>등록자명</th>
						<th>등록아이디</th>
						<th>수정아이디</th>
						<th>등록아이피</th>
						<th>수정아이피</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty list}">
							<tr>
							    <td colspan="12" style="text-align: center;">검색 결과가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${list}" var="m">
								<tr onclick="location.href='detail?memoNum=${m.memoNum}'" style="cursor:pointer;">
									<td onclick="event.stopPropagation()"><input type="checkbox" id="${m.memoNum}" name="checkDel"/></td>
									<td>${m.memoNum}</td>
									<%-- <td><a href="detail?memoNum=${m.memoNum}">${m.userId}</a></td> --%>
									<td style="width:16%">
										<c:if test="${m.noticeYN eq 'Y'}">
											<img src="./resources/img/notice.png"/>
										</c:if>
										${m.title}
									</td>
									<td style="width:20%">
										<c:if test="${m.contentReply ne '' and not empty m.contentReply}">
											<img src="./resources/img/feedback.png"/>
										</c:if>
										${m.content}
									</td>
									<td>${m.writeDate}</td>
									<td>${m.registDate}</td>
									<td>${m.updateDate}</td>
									<td>${m.userName}</td>
									<td>${m.registId}</td>
									<td>${m.updateId}</td>
									<td>${m.registIp}</td>
									<td>${m.updateIp}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>	
			</table>
		</form>
		<div style="text-align: center;">
			<ul class="pagination">
			    <c:if test="${paging.prev}">
			    	<li>
			    		<a href='<c:url value="./?page=${paging.startPage - 1}&memoSearch=${search.memoSearch}&memoWord=${search.memoWord}"/>'>◀</a>
			    	</li>
			    </c:if>
			    <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
					<!-- 선택 페이지인 경우 링크안생기게 처리 -->
					<c:choose>
						<c:when test="${paging.cri.page == num}">
							<li style="color: #355400; font-weight:bold; padding:3px 8px; border: 1px solid #dadada; background-color: #9CAF72;">
								${num}
							</li>
						</c:when>
						<c:otherwise>
							<li>
								<a href='<c:url value="./?page=${num}&memoSearch=${search.memoSearch}&memoWord=${search.memoWord}"/>'>${num}</a>
							</li>
						</c:otherwise>
					</c:choose>
			    </c:forEach>
			    <c:if test="${paging.next && paging.endPage > 0}">
			    	<li>
			    		<a href='<c:url value="./?page=${paging.endPage + 1}&memoSearch=${search.memoSearch}&memoWord=${search.memoWord}"/>'>▶</a>
			    	</li>
			    </c:if>
			</ul>
		</div>
	</body>
</html>
