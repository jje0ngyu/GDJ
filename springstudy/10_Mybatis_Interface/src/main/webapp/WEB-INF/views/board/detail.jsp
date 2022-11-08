<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="${contextPath}/resources/js/jquery-3.6.1.min.js" ></script>

<script>
		
	$(document).ready(function(){
		
		var frm = $('#frm_btn');
		
		// 편집화면으로 이동
		$('#btn_edit').click(function(event){
			frm.attr('action','${contextPath}/brd/edit');
			frm.submit();
			return;
		});
		
		// 삭제
		$('#btn_remove').click(function(event){
			if(confirm('삭제할까요?')) {
				frm.attr('action', '${contextPath}/brd/remove');
				frm.submit();
				return;
				
			} else { 
				alert('취소되었습니다.');
				event.preventDaefault();
				return;
			}
		});
		
		// 목록
		$('#btn_list').click(function(){
			location.href="${contextPath}/brd/list";
		});
	});
		

</script>

</head>
<body>

	<ul>
		<li>글번호 : ${board.boardNo}</li>
		<li>제목 : ${board.title}</li>
		<li>작성자 : ${board.writer}</li>
		<li>작성일 : ${board.createDate}</li>
		<li>수정일 : ${board.modifyDate}</li>
	</ul>
	<div>
		${board.content}
	</div><hr />
	
	<div>
		<!-- ############################################################################################ 
		
				■ 하나의 <form> 안에 2가지 이상의 submit을 하는 방법 ■
				
				Q. 왜 그렇게 하나요?
				A. 모두 POST 방식을 해야하기 때문, 또한 여러 개의 폼을 생성하게 되면 CSS의 번거롭다.
			
				■ 방법 순서 ■
					1. <form>에 action이 삭제된다.
					2. 타입은 'button'이 된다.
					3. script에서 이벤트로 작동되게 한다.
					
		     ############################################################################################ -->
		<form id="frm_btn" method="post">
			<input type="hidden" name="boardNo" value="${board.boardNo}">
			<input type="button" value="편집" id="btn_edit">
			<input type="button" value="삭제" id="btn_remove">
			<input type="button" value="목록" id="btn_list">
		</form>
	</div>
	

</body>
</html>