<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 
	<a href="${contextPath}/board/detail">게시판</a><hr />
	<!-- * "board/detail"은
		MyController.java에 작성한 @GetMapping("board/detail") 이다.
		board파일의 detail.jsp을 가리키는게 아니다! ★
		
		cf) DBCP를 배울 때 사용했던, detail.do 와 비슷한 역할을 한다.
	-->
	
	<a href="${contextPath}/notice/detail">공지사항</a> 
	
</body>
</html>