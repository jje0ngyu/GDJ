<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../../assets/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<%
		// rememberId 쿠키가 있으면 해당 쿠키값을 id="id" 입력 요소에 표시
		String rememberId = "";	//* 스크립트에서도 빈문자열로 통일하는 것이 편하다.
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (int i = 0; i < cookies.length; i++){
				if(cookies[i].getName().equals("rememberId")){
					rememberId = cookies[i].getValue();
					break;
				}
			}
		}
	%>
	<div>
		<form method="POST" action="02_remember_id.jsp"> <!-- 비밀번호는 반드시 POST형식 !! -->
			<div>
				<input type="text" name="id" id="id" placeholder="아이디">
			</div>
			<div>
				<input type="password" name="pwd" id="pwd" placeholder="비밀번호">
			</div>
			<div>
				<button>로그인</button>
			</div>
			<div>
				<label for="chk_remember_id">
					<input type="checkbox" name="chk_remember_id" id="chk_remember_id">
					아이디 기억하기
				</label>
			</div>
		</form>
	</div>
	
	<script>
		// String rememberId가 ""이 아니면 아이디 기억하기를 한 상황
		if('<%=rememberId%>' != ''){
			$('#id').val('<%=rememberId%>');
			$('#chk_remember_id').prop('checked', true);
		}
	</script>
</body>
</html>