<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	request.setCharacterEncoding("UTF-8");
 	String title = request.getParameter("title");
 	if(title == null){
 		title = "환영합니다.";
 	}
 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=title%></title>
</head>
<body>

	<header>
		<h1>홈페이지</h1>
		<nav>
			<ul>
				<li><a href="body_economic.jsp">경제</a></li>
				<li><a href="body_society.jsp">사회</a></li>
				<li>사회3</li>
				<li>사회4</li>
			</ul>
		</nav>
	</header>