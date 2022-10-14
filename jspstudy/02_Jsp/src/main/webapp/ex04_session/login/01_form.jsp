<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 로그인 성공 시 session에 id,pwd 저장된 상태 --%>
	<%
		Object id = session.getAttribute("id");
		Object pwd = session.getAttribute("pwd");
	%>
	
	<% if(id != null && pwd != null){ %>
			${id}님 환영합니다. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- 이때 id는 Object id (자바변수)가 아니라 session에 저장된 id값이다. -->
			
			<input type="button" value="로그아웃" id="btn_logout">
	<% } else { %>
		<!-- 아이디 & 비밀번호 -->
		<div>
			<form method="POST" action="02_login.jsp"> <!-- 비밀번호는 반드시 POST형식 !! -->
				<div>
					<input type="text" name="id" placeholder="아이디">
				</div>
				<div>
					<input type="password" name="pwd" placeholder="비밀번호">
				</div>
				<div>
					<button>로그인</button>
				</div>
			</form>
		</div>
	<% } %>
	<!-- 로그아웃 -->
	<script> //* type은 지워도 된다.
		document.getElementById('btn_logout').onclick = function(event) {
			location.href='03_logout.jsp';
		}
	</script>

</body>
</html>