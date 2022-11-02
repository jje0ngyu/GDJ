<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- installation 을 사용하기 위해 필요한 코드 -->

<script src="${contextPath}/resources/js/jquery-3.6.1.min.js" ></script>
<link rel="stylesheet" href="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.css">
<script src="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.js"></script>
<script src="${contextPath}/resources/summernote-0.8.18-dist/lang/summernote-ko-KR.min.js"></script>

<script>
		
	$(document).ready(function(){
		$('#content').summernote({
			lang: 'ko-KR',
			height: 300,
			width: 700
		});
	});
		

</script>

</head>
<body>

	<textarea id="content"></textarea>

</body>
</html>