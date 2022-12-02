<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		box-sizing: border-box;
	}
	a {
		text-decoration: none;
		color: gray;
	}
	.paging {
		width: 210px;
		margin: 0 auto;
		color: gray;
	}
	.paging a, .paging span {
		display: inline-block;
		width: 30px;
		height: 30px;
		line-height: 30px;
		text-align: center;
	}
	.hidden {
		visibility: hidden;
	}
	.now_page {
		border: 1px solid gray;
		color: teal;
		font-weight: 900;
	}
	.lnk:hover {
		border: 1px solid gray;
		color: skyblue;
	}
</style>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>

	$(document).ready(function(){
		
		// 세션에 recordPerPage가 없는 경우 recordPerPage 10으로 초기화
		var recordPerPage = ('${recordPerPage}'=='') ? '10' : '${recordPerPage}';
		$('#recordPerPage').val(recordPerPage);
		
		// recordPerPage 변경
		$('#recordPerPage').change(function(){
			location.href = '${contextPath}/emp/change/list?recordPerPage=' + $(this).val();
		});
		
		// 필드 제목으로 정렬
		$('.title').click(function(){
			location.href = '${contextPath}/emp/list?title=' + $(this).data('title') + '&order=' + $(this).data('order') + '&page=${page}';
		});
		
		// 자동 완성
		$('#query').keyup(function(){
			$('#auto_complete').empty();
			if($(this).val() == ''){
				return;
			}
			$.ajax({
				/* 요청 */
				type: 'get',
				url: '${contextPath}/emp/autoComplete',
				data: 'column=' + $('#column').val() + '&query=' + $(this).val(),
				/* 응답 */
				dataType: 'json',
				success: function(resData){
					if(resData.status == 200){
						$.each(resData.list, function(i, emp){
							$('#auto_complete')
							.append($('<option>').val(emp[resData.column]));
						});
					}
				}
			});
		});
		
	});
	
</script>
</head>
<body>

	<div>
		<h1>조회 가능한 목록을 자동완성으로 확인하기</h1>
		<form action="${contextPath}/emp/search">
			<select name="column" id="column">
				<option value="FIRST_NAME">이름</option>
				<option value="LAST_NAME">성</option>
				<option value="EMAIL">이메일</option>
			</select>
			<input type="text" name="query" id="query" list="auto_complete">
			<datalist id="auto_complete"></datalist>
			<input type="submit" value="조회">
		</form>
	</div>
	
	<hr>

	<div>
		<select id="recordPerPage">
			<option value="10">10개</option>
			<option value="20">20개</option>
			<option value="30">30개</option>
		</select>
		<table>
			<thead>
				<tr>
					<td>순번</td>
					<td><span class="title" data-title="EMPLOYEE_ID" data-order="${order}">사원번호</span></td>
					<td><span class="title" data-title="FIRST_NAME" data-order="${order}">사원명</span></td>
					<td><span class="title" data-title="EMAIL" data-order="${order}">이메일</span></td>
					<td><span class="title" data-title="PHONE_NUMBER" data-order="${order}">전화번호</span></td>
					<td><span class="title" data-title="HIRE_DATE" data-order="${order}">입사일자</span></td>
					<td><span class="title" data-title="SALARY" data-order="${order}">연봉</span></td>
					<td><span class="title" data-title="COMMISSION_PCT" data-order="${order}">커미션</span></td>
					<td><span class="title" data-title="DEPARTMENT_ID" data-order="${order}">부서번호</span></td>
					<td><span class="title" data-title="DEPARTMENT_NAME" data-order="${order}">부서명</span></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="emp" varStatus="vs">
					<tr>
						<td>${beginNo - vs.index}</td>
						<td>${emp.employeeId}</td>
						<td>${emp.firstName} ${emp.lastName}</td>
						<td>${emp.email}</td>
						<td>${emp.phoneNumber}</td>
						<td>${emp.hireDate}</td>
						<td>${emp.salary}</td>
						<td>${emp.commissionPct}</td>
						<td>${emp.deptDTO.departmentId}</td>
						<td>${emp.deptDTO.departmentName}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="10">
					    ${paging}
					</td>
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>