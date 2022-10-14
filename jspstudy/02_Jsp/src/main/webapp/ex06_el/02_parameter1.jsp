<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<form method="GET" action="02_parameter2.jsp">
			<div>
				<input type="text" name="a">
				<!-- * input에 들어가 있는 name="a"는 속성이 아니라, 파라미터이다 !! -->
				<!-- * request에 저장되는 것은 2가지이다. ① 속성 ② 파라미터 -->
			</div>
			<div>
				<input type="text" name="b">
			</div>
			<div>
				<input type="submit" value="전송">
			</div>
		</form>
	</div>
</body>
</html>