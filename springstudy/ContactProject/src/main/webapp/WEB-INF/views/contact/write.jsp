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
		// 목록
		$('#btn_list').click(function(){
			location.href='${contextPath}/contact/list';
		});
		
		// 서브밋
		$('#frm_contact').submit(function(event){
			if ($('#name').val() =='') {
				alert('이름을 입력해주세요.')
				event.preventDefault();
				return;
			}
			if ($('#tel').val() =='') {
				alert('전화를 입력해주세요.')
				event.preventDefault();
				return;
			}
			if ($('#addr').val() =='') {
				alert('주소를 입력해주세요.')
				event.preventDefault();
				return;
			}
		})
	})
</script>
</head>
<body>
	<div>
		<h1>연락처 등록</h1>
		<form id="frm_contact" action="${contextPath}/contact/add" method="post">
			<div>
				<label for="name">이름*</label>
			</div>
			<input type="text" name="name" id="name">
			<div>
				<label for="tel">전화*</label>
			</div>
			<input type="text" name="tel" id="tel">
			<div>
				<label for="addr">주소*</label>
			</div>
			<input type="text" name="addr" id="addr">
			<div>
				<label for="note">비고</label>
			</div>
			<input type="text" name="note" id="note">
			<div>
				<input type="submit" value="연락처 저장하기">
				<input type="button" id="btn_list" value="전체 연락처">
			</div>
		</form>
	</div>
</body>
</html>