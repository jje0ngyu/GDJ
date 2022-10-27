<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.boardNo}번 게시글</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	
	function fn_list () {
		location.href = '${contextPath}/board/list.do';
	};
	
	function fn_remove() {
		if(confirm('게시글을 삭제할까요?')){
			location.href = '${contextPath}/board/remove.do?boardNo=${board.boardNo}';
		} else {
			alert('취소되었습니다.')
		}
		
	};
	
</script>
</head>
<body>

	<form method="POST" action="${contextPath}/board/modify.do">
		<table border="1">
			<tbody>
				<tr>
					<td>순번</td>
					<td><input type="text" name="boardNo" value="${board.boardNo}"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${board.name}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value="${board.title}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" rows="30" cols="50">${board.content}</textarea> </td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정">
						<input type="button" value="목록" onclick="fn_list()">
						<input type="button" value="삭제" onclick="fn_remove()">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>

</body>
</html>