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

	<!-- * 링크 주소는 Controller에서 필요한 메소드의 @GetMapping 값을 적어주면 된다. -->
	<a href="${contextPath}/brd/list">게시판가기</a>

</body>
</html>