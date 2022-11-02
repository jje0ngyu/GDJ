<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	
	<h1>예쁜 동물들 보고 가세요</h1>
	
	<!--  <img src="C:\GDJ\images\animal1.jpg" width="200px">
		* 이렇게 작성할 경우, 이미지 주소가 "about:blank#blocked" 가 되어있다.
		  즉, 절대경로는 사용 불가능하다! 
		  
	 ---- 오늘의 학습 포인트 ----------------------------
	   ※ 절대경로를 이용해 image를 불러오자 !
	 ---------------------------------------------------- -->
	
	<!-- 
		절대 경로의 이미지를 <img> 태그로 표시하기
		1. 요청
			1) 경로 + 이미지를 파라미터로 전송
		2. 응답
			이미지의 byte[]
			
	 -->
	<div id="galleries"></div>
	<script>
		/* <img id="gallery">
		/* * src 경로를 태그 안에 작성할 경우 400번 오류가 발생한다. <script>를 이용해 오류를 해결하자. */
			for(let n = 1; n <= 10; n++) {
				/* 한 줄에 여러 개 뽑아내기
				$('<img>')
					.attr('src', '${contextPath}/image/display?path=' + encodeURIComponent("C:\\GDJ\\images") + '&filename=animal'+n+'.jpg');
					.attr('width', '200px')
					.appendTo('#galleries');
				
				*/
				/* 한 줄에 한 개씩 뽑아내기 */
				$('<div>')
				.append($('<img>')
						.attr('src', '${contextPath}/image/display?path=' + encodeURIComponent('C:\\GDJ\\images') + '&filename=animal' + n + '.jpg')
						.attr('width', '200px'))
				.appendTo('#galleries');
					
			}
		
		
	</script>
	
</body>
</html>