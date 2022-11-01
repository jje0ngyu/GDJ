<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<style>
	p {
		font-size : 10px;
		color : orange;
	}
</style>
</head>
<body>
	
	<img src="${contextPath}/resources/images/hooray.jpg" width="200px"><hr />
	
	
	
	<h3>Member 관한 요청</h3>
	
	<!-- MyController1.java -----------------------------------------------------------------------  -->
	
	<p>a링크를 이용한 get 방식</p>
	<div>
		<a href="${contextPath}/member/detail1?id=admin&pw=1234">전송</a>
	</div>
	
	
	
	<p>location을 이용한 get 방식</p>
	<div>
		<input type="button" value="전송" id="btn">
	</div>
	<script>
		$('#btn').click(function(){
			// location.href='${contextPath}/member/detail2?id=admin&pw=1234';	
			// location.href='${contextPath}/member/detail2';
			
			//location.href='${contextPath}/member/detail3?id=admin&pw=1234';
			location.href='${contextPath}/member/detail3';
		})
	</script>
	
	
	
	<p>form을 이용한 get 방식 </p>
	<form action="${contextPath}/member/detail4" method="post">
		<div>
			<input type="text" name="id" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="pw" placeholder="패스워드">
		</div>
		<button>전송</button>
	</form><hr />
	
	
	<!-- MyController2.java -----------------------------------------------------------------------  -->
	
	
	<div>
		<a href="${contextPath}/board/detail1?title=공지사항&hit=10">전송</a>
	</div>
	<div>
		<a href="${contextPath}/board/detail3?title=공지사항&hit=300">전송</a>
	</div>
	
	
	


</body>
</html>