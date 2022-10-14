<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		EL의 파라미터 처리
		1. EL 내장객체 param을 사용 (param, paramValues)
		2. 모든 파라미터는 String이므로 크기 비교가 정상이 아니다.
			예시)
			"10", "5" 중 누가 큰가?	"5"가 크다 (문자열의 크기는 사전 '편찬순'이다.)
		3. 파라미터의 크기 비교
			두 파라미터의 차이를 구한 뒤 0보다 큰지 여부를 판단
			두 파라미터의 차이를 구하면 결과는 숫자가 반환
			"10" - "5" == 5
	--%>
	
	<div>${param.a + param.b}</div>
	<div>${param.a - param.b}</div>
	<div>${param.a * param.b}</div>
	<div>${param.a / param.b}, ${param.a div param.b}</div>
	<div>${param.a % param.b}, ${param.a mod param.b}</div>
	
	<div>${param.a <  param.b}, ${param.a lt param.b }</div>
	<div>${param.a <= param.b}, ${param.a le param.b }</div>
	<div>${param.a >  param.b}, ${param.a gt param.b }</div>
	<div>${param.a >= param.b}, ${param.a ge param.b }</div>
	<div>${param.a == param.b}, ${param.a eq param.b }</div>
	<div>${param.a != param.b}, ${param.a ne param.b }</div>
	
	<div>${param.a == 7 && param.b == 2}, ${param.a eq 7 and param.b eq 2}</div>
	<div>${param.a == 7 || param.b == 2}, ${param.a eq 7 or  param.b eq 2}</div>
	<div>${!(param.a == 7)}, ${not (param.a == 7)}</div>
	
	<div>${param.a == 7 ? "param.a는 7이다" : 'param.a는 7이 아니다'}</div>
	<!-- * 문자열은 큰 따옴표(")와 작은 따옴표(') 모두 사용가능 -->
</body>
</html>