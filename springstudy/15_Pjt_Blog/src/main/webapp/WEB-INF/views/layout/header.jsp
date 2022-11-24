<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Optional<String> opt = Optional.ofNullable(request.getParameter("title"));
	String title = opt.orElse("Welcome");
	pageContext.setAttribute("title", title);	// EL사용을 위해 (${title})
	pageContext.setAttribute("contextPath", request.getContextPath());
%>
<!-- 일반 자바변수는 EL로 사용할 수 없다.
	 EL로 사용가능 : pageContext
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>

<%--
	아래 script는 주소가 아니다! (경로 x) 
	servlet-context.xml에 작성되어 있는 <resources> 태그에 작성된 mapping 값을 적어준 것이다. (매핑 o)
	${contextPath}를 붙이는 이유는 매핑이란 것을 알려주기 위함.?
--%>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script src="${contextPath}/resources/js/moment-with-locales.js"></script>
<script src="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.js"></script>
<script src="${contextPath}/resources/summernote-0.8.18-dist/lang/summernote-ko-KR.min.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.css">
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<div>
		<h1>Welcome To My BLOG</h1>
	</div>
	
