<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- installation 을 사용하기 위해 필요한 코드 -->

<script src="${contextPath}/resources/js/jquery-3.6.1.min.js" ></script>
<link rel="stylesheet" href="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.css">
<script src="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.js"></script>
<script src="${contextPath}/resources/summernote-0.8.18-dist/lang/summernote-ko-KR.min.js"></script>

<script>
	/* -----------------------------------------------------------------------
	 	Ajax 사용 중 summernote({}) 의 사용법 참고 : https://summernote.org/
	-------------------------------------------------------------------------- */
	$(document).ready(function(){
		$('#content').summernote({
			lang: 'ko-KR',
			height: 400,
			width: 800,
			
			toolbar: [
			    // [groupName, [list of button]]
			    ['style', ['bold', 'italic', 'underline', 'clear']],
			    ['font', ['strikethrough', 'superscript', 'subscript']],
			    ['fontsize', ['fontsize']],
			    ['color', ['color']],
			    ['para', ['ul', 'ol', 'paragraph']],
			    ['height', ['height']]
			 ]
		});
		
		
		// 목록
		$('#btn_list').click(function(){
			location.href='${contextPath}/brd/list';
		});
		
		// 서브밋
		$('#frm_board').submit(function(event){
			if($('#title').val() == ''){
				alert('제목은 필수입니다.');
				event.preventDefault();	// 서브밋 취소
				return; // 이후 코드 동작 방지
			}
		});
			/*
				■ 설명 ■
				
				if문을 사용한 이유?
							▷ 값이 비었을 때 경고창 띄우기 (why? NOT NULL 요소!)
			
				$('#title').val() : title에 입력된 값
							▷ String 이므로 빈 문자열('')로 입력된 값이 없음을 구분
			 */
	});
	
	
		

</script>

</head>
<body>
	
	<div>
		<h1>수정 화면</h1>
		<form id="frm_board" action="${contextPath}/brd/modify" method="post">
			<input type="hidden" name="board_no" value="${board.board_no}">
			<div>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" value="${board.title}">
			</div>
			<div>
				<label for="writer">작성자</label>
				<input type="text" name="writer" id="writer" value="${board.writer}" readonly>
			</div>
			<div>
				<label for="content">내용</label>
				<textarea id="content" name="content">${board.content}</textarea>
			</div>
			<div>
				<button>수정 완료</button>
				<input type="reset" value="입력초기화">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>

</body>
</html>