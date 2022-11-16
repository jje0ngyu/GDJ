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
<script>
	$(function(){
		fn_list();	// 목록 가져오기
		fn_add();	// 사원 추가하기
		fn_search();// 사원 조회하기
	});
	
	// 목록 가져오기
	function fn_list(){
		$.ajax({
			type: 'get',
			url : '${contextPath}/list.json',
			dataType: 'json',
			success : function(resData){
				$('#list').empty();	
				$('#frm_search').val('');
				$.each(resData, function(i, staff){
					var tr = '<tr>';
					tr += '<td>' + staff.sno + '</td>';
					tr += '<td>' + staff.name + '</td>';
					tr += '<td>' + staff.dept + '</td>';
					tr += '<td>' + staff.salary + '</td>';
					tr += '</tr>';
					$('#list').append(tr);				
				});
			}
		}) // ajax
	} // function
	
	// 사원 추가하기
	function fn_add(){
		$('#btn_add').click(function(){
			if(/^[0-9]{5}$/.test($('#sno').val()) == false) {
				alert('사원번호는 5자리 숫자입니다.');
				return;
			}
			$.ajax({
				type: 'post',
				url : '${contextPath}/add',
				data: $('#frm_add').serialize(),
				dataType: 'text',
				success : function(resData){	// java ▷ try
					alert(resData);
					fn_list();
					$('#frm_add').val('');	// 추가하기에 입력된 정보 지우기
				},
				error : function(jqXHR){		// java ▷ catch
					alert(jqXHR.responseText);
				}
			});
		});	// click
	} // function
	
	 // 사원 조회하기
	 function fn_search(){
		$('#btn_search').click(function(){
			$.ajax({
				type: 'get',
				url : '${contextPath}/query.json',
				data: $('#frm_search').serialize(),
				dataType: 'json',
				success : function(resData){
					$('#list').empty();	
					var tr = '<tr>';
					tr += '<td>' + resData.sno + '</td>';
					tr += '<td>' + resData.name + '</td>';
					tr += '<td>' + resData.dept + '</td>';
					tr += '<td>' + resData.salary + '</td>';
					tr += '</tr>';
					$('#list').append(tr);		
				},
				error : function(){
					alert("조회된 사원 정보가 없습니다.");
				}
			}); // ajax
		}); // submit
	}
 

	
</script>
</head>
<body>
	<h3>사원등록</h3>
	<form id="frm_add">
		<input type="text" id="sno" name="sno" placeholder="사원번호">
		<input type="text" id="name" name="name" placeholder="사원명">
		<input type="text" id="dept" name="dept" placeholder="부서명">
		<input type="button" value="등록" id="btn_add">
	</form><hr />
	
	<h3>사원조회</h3>
	<form id="frm_search">
		<input type="text" id="query" name="query" placeholder="사원번호">
		<input type="button" id="btn_search" value="조회">
		<input type="button" value="전체" onclick="fn_list();">
	</form><hr />

	<h3>사원목록</h3>
	
	<table border="1">
		<thead>
			<tr>
				<td>사원번호</td>
				<td>사원명</td>
				<td>부서명</td>
				<td>연봉</td>
			</tr>
		</thead>
		<tbody id="list">
			
		</tbody>
	</table>

</body>
</html>