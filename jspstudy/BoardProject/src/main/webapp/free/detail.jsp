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
<script>
	
	$(document).ready(function(){
	
		$('#btn_list').click(function(){
			location.href="${contextPath}/free/list.do";
		});
		
	});
	
</script>
<style>
	.box {
		border : none;
		outline : none;
	}
</style>
</head>
<body>
	
	<h1>자유게시판 게시글 상세보기</h1>
	
	<form action="${contextPath}/free/modify.do" method="post">
		<div>
			게시글번호 <input type="text" id="freeNo" name="freeNo" class="box" value="${free.freeNo}" readonly>
		</div>
		<div>
			아이피 <input type="text" id="ip" name="ip" class="box" value="${free.ip}" readonly>
		</div>
		<div>
			조회수 <input type="text" id="hit" name="hit" class="box" value="${free.hit}" readonly>
		</div>
		<div>
			작성자 <input type="text" id="writer" name="writer" class="box" value="${free.writer}" readonly>
		</div>
		<div>
			제목 <input type="text" id="title" name="title" value="${free.title}">
		</div>
		<div>
			<textarea name="content" rows="15" cols="30">${free.content}</textarea>
		</div>
		<div>
			<button>수정</button>
			<input type="button" id="btn_list" value="목록">
		</div>	
	</form>
	
</body>
</html>