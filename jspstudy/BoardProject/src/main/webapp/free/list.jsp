<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
<body>
	
	<a href="${contextPath}/free/insert.do">작성하러 가기</a><hr />
	
	<form method="get">
		<table border="1">
			<thead>
				<tr>
					<td>게시글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>조회수</td>
					<td>삭제</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${frees}" var="f">
				<tr>
					<td>${f.freeNo}</td>
					<td><a href="${contextPath}/free/detail.do?freeNo=${f.freeNo}">${f.title}</a></td>
					<td>${f.writer}</td>
					<td>${f.hit}</td>
					<td><a href="${contextPath}/free/remove.do?freeNo=${f.freeNo}">X</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	
</body>
</html>