<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<div>
		<form id="frm_write" action="add.do" method="post">
			<table border="1">
				<tbody>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="name" id="name"></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" id="title"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="content" rows="15" cols="30"></textarea> </td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="submit" value="등록">
							<input type="button" value="목록" id="btn_list">
							<script>
							$('#btn_list').on('click', function(event){
								location.href = '${contextPath}/board/list.do';
							})
							</script>
						</td>
					</tr>
				</tfoot>
			</table>			
		</form>
	</div>

</body>
</html>