<!doctype html>
<html xmlns:th="http://www.thymeleaf.org">
<style>
	.blind {
		display : none;
	}
</style>

<div>

	<h1 th:text="${blog.title}"></h1>
	
	<div>
		<!--
			<span>▷ 작성일<fmt:formatDate value="${blog.createDate}" pattern="yyyy.M.d HH:mm"/></span>
		-->
		<!-- 
			<span th:text="▷ 작성일 ${blog.createDate}"> pattern="yyyy.M.d HH:mm"/></span>
				expression 외에 다른 것이 th:text에 함께 있으면 문제 된다.
				1. th:text를 여러 개 사용
				2. 식으로 정리한다. (아래 코드에 적용)
				3. 파이프(|) 사용
		 -->
		 <!--
		 	날짜 형식 지정하기
		 	1. Date 타입						${#dates.format(날짜, '패턴')}
		 	2. VARCHAR 타입 					${#temporals.format(날짜, '패턴')}
		 	   LocalDate 타입	(*날짜만 사용)	${#temporals.format(날짜, '패턴')}
		 	   LocalTime 타입	(*시간만 사용)	${#temporals.format(날짜, '패턴')}
		 	   LocalDateTime 타입 				${#temporals.format(날짜, '패턴')}
		 	3. Calendar 타입					${#calendars.format(날짜, '패턴')}
		 	* '패턴'은 SimpleDateFormat의 패턴을 그대로 사용	
		 -->
		<span th:text="'▷ 작성일' + ${#dates.format(blog.createDate, 'yyyy.M.d HH:mm')}" ></span>
		<span th:text="|▷ 작성일 ${#dates.format(blog.createDate, 'yyyy.M.d HH:mm')}|"></span>
		&nbsp;&nbsp;&nbsp;
		<!--
			패턴 표기할 때
				오전/오후 표기   → a hh:mm	(시간을 소문자(h)로 작성)
				요전/오후 비표기 → HH:mm	(시간을 대문자(H)로 작성)
		-->
		<span th:text="|▷ 수정일 ${#dates.format(blog.modifyDate, 'yyyy.M.d a hh:mm'}|"></span>
	</div>
	<div>
		<!--
			숫자 형식 지정하기 
			
			1. 정수 형식		${#numbers.formatInteger(숫자,자릿수,천단위 구분 기호)}
			2. 실수 형식		${#numbers.formatDecimal(숫자,정수자릿수,천단위 구분 기호,소수자릿수,정수소수구분자리)}
		-->
		<span th:text="'조회수' + ${#numbers.formatInteger(blog.hit, 1, 'COMMA')}"></span><!-- 구분 기호 : POINT - 마침표(.)일 경우 -->
	</div>
	
	<hr />
	
	<div>
		${blog.content}
	</div>
	<div>
		<!-- 작성자만 보여주기 -->
		<form id="frm_btn" method="post">
			<input type="hidden" name="blogNo" value="${blog.blogNo}">
			<input type="button" value="수정" id="btn_edit_blog">
			<input type="button" value="삭제" id="btn_remove_blog">
		</form>
		<script>
			$('#btn_edit_blog').click(function(){
				$('#frm_btn').attr('action', '${contextPath}/blog/edit');
				$('#frm_btn').submit();
			});
			$('#btn_remove_blog').click(function(){
				if(confirm('블로그를 삭제하면 블로그에 달린 댓글을 더 이상 확인할 수 없습니다. 삭제하시겠습니까?')){
					$('#frm_btn').attr('action', '${contextPath}/blog/remove');
					$('#frm_btn').submit();
				}
			});
		</script>
	</div>
	
	<hr />
	
	<span id="btn_comment_list">댓글
		<span id="comment_count"></span>개
	</span>
	
	<hr />
	
	<div id="comment_area" class="blind">
		<div id="comment_list"></div>
		<div id="paging"></div>
	</div>
	
	<hr />
	
	<div>
		<form id="frm_add_comment">
			<div class="add_comment">
				<div class="add_comment_input">
					<input type="text" name="content" id="content" placeholder="댓글을 작성하려면 로그인 해 주세요.">
				</div>
				<div class="add_comment_btn">
					<input type="button" value="작성완료" id="btn_add_comment">
				</div>
			</div>	
			<input type="hidden" name="blogNo" value="${blog.blogNo}">	
		</form>
	</div>
	<!-- 현재 페이지 번호를 저장하고 있는 hidden -->
	<input type="hidden" id="page" value="1">
	
	<script>
		
		// 전역 변수 page 	(모든 함수에서 사용 가능)
		var page = 1;

		// 함수 호출
		fn_commentCount();
		fn_switchCommentList();
		fn_addComment();
		fn_commentList();
		fn_changePage();
		fn_removeComment();
		fn_switchReplyArea();
		fn_addReply();
		
		// 함수 정의
		function fn_commentCount(){
			$.ajax({
				type: 'get',
				url : '${contextPath}/comment/getCount',
				data: 'blogNo=${blog.blogNo}',
				dataType: 'json',
				success : function(resData){	// resData = {"commentCount": 개수}
					$('#comment_count').text(resData.commentCount);
				}
			});
		};
		
		function fn_addComment(){
			$('#btn_add_comment').click(function(){
				if($('#comment').val() == ''){
					alert('댓글 내용을 입력하세요');
					return;
				}
				$.ajax({
					type: 'post',
					url : '${contextPath}/comment/add',
					data: $('#frm_add_comment').serialize(),
					dataType: 'json',
					success : function(resData){	// resData = {"isAdded",true}
						if(resData.isAdd){
							alert('댓글이 등록되었습니다.');
							$('#content').val('');	// 컨텐츠 내용 지워주기
							fn_commentList();	// 댓글 목록 가져와서 뿌리는 함수
							fn_commentCount();	// 댓글 목록 개수 갱신하는 함수
						}
					}
				});
			});
		};
		
		function fn_commentList(){
			$.ajax({
				type:'get',
				url :'${contextPath}/comment/list',
				data:'blogNo=${blog.blogNo}&page=' + $('#page').val(),	// 페이징 처리를 위해, 현재 page도 파라미터로 전달!
				dataType: 'json',
				success : function(resData){
					/* 
						resData = {
							"commentList" : [
								{댓글하나},
								{댓글하나},
								...
							],
							"pageUtil" : {
								page : x,
								...
							}
					}
					*/
					// 화면에 댓글 목록 뿌리기
					$('#comment_list').empty();
					$.each (resData.commentList, function(i, comment){
						// 댓글내용
						//		답글내용
						var div = '';
						if(comment.depth == 0){
							div += '<div>';
						} else {
							div += '<div style="margin-left: 40px;">';
						}
						if (comment.state == 1) {
							div += '<div>' + comment.content;
							// 작성자만 삭제할 수 있도록 if 처리 필요
							div += '<input type="button" value="삭제" class="btn_comment_remove" data-comment_no="' + comment.commentNo + '">'; 
							if(comment.depth == 0){
								div += '<input type="button" value="답글" class="btn_reply_area">';
							}
							div += '</div>';
						} else {
							if(comment.depth == 0){
								div += '<div>삭제된 댓글입니다.</div>';
							} else {
								div += '<div>삭제된 답글입니다.</div>';
							}
						}
						// 댓글내용 밑에 시간표기
						// 2022.11.28 11:00 
						div += '<div>';
						moment.locale('ko-KR');
						div += '<span style="font-size: 12px; color:silver;">'+ moment(comment.createDate).format('YYYY.MM.DD hh:mm') + '</span>';
						div += '</div>';
							// 답글 reply
							div += '<div style="margin-left: 40px;" class="reply_area blind">';
								div += '<form class="frm_reply">';
								div += '<input type="hidden" name="blogNo" value="' + comment.blogNo + '">';
								div += '<input type="hidden" name="groupNo" value="' + comment.commentNo + '">';
								div += '<input type="text" name="content" placeholder="답글을 작성하려면 로그인을 해주세요">';
								// 로그인한 사용자만 볼 수 있도록 if 처리
								div += '<input type="button" value="답글작성완료" class="btn_reply_add">';
								div += '</form>';
							div += '</div>';
						div += '</div>';
						$('#comment_list').append(div);
						$('#comment_list').append('<div style="border-bottm: 1px dotted gray;"></div>');
					});
					// 페이징
					$('#paging').empty();
					var pageUtil = resData.pageUtil;
					var paging ='';
					// 이전 블록
					if (pageUtil.beginPage != 1){
						paging += '<span class="enable_link" data-page="' + (pageUtil.beginPage - 1) + '">◀</span>';
					}
					// 페이지번호
					for (let p = pageUtil.beginPage; p <= pageUtil.endPage; p++){
						if(p ==  $('#page').val()) {
							paging += '<strong>' + p + '</strong>';
						} else {
							paging += '<span class="enable_link" data-page="'+p+'">' + p + '</span>';
						}
					}
					// 다음 블록
					if(pageUtil.endPage != pageUtil.totalPage){
						paging += '<span class="enable_link" data-page="' + (pageUtil.endPage + 1) + '">▶</span>';
					}
					// 화면에 뿌리기
					$('#paging').append(paging);
				}
			});
		};
		
		function fn_changePage(){
			// 자바스크립트로 만든 아이들은 아래와 같은 코드로 작동시켜야한다. (동적요소는 일반 클릭이벤트로 이동하지 않는다.)
			// $(만들어져있었던부모).on('click', '.enable_link', (function(){ }));
			$(document).on('click', '.enable_link', function(){
				$('#page').val( $(this).data('page') );
				fn_commentList();
			})
		};
		
		function fn_switchCommentList(){
			$('#btn_comment_list').click(function(){
				$('#comment_area').toggleClass('blind');
			});
		};
		
		function fn_removeComment(){
			$(document).on('click', '.btn_comment_remove', function(){
				if(confirm('삭제된 댓글은 복수할 수 없습니다. 댓글을 삭제할까요?')){
					$.ajax({
						type: 'post',
						url : '${contextPath}/comment/remove',
						data: 'commentNo=' + $(this).data('comment_no'),
						dataType: 'json',
						success : function(resData){	// resData = {"isRemove" : true}
							if(resData.isRemove) {
								alert('댓글이 삭제되었습니다.');
								fn_commentList();  // 목록 갱신
								fn_commentCount(); // 개수 갱신
							}
						}
					});
				}
			});
			
		};
		
		function fn_switchReplyArea(){
			$(document).on('click', '.btn_reply_area', function(){
				$(this).parent().next().next().toggleClass('blind');
			});
		};
		
		function fn_addReply() {
			$(document).on('click', '.btn_reply_add', function(){
				if($(this).prev().val() == ''){
					alert('답글 내용을 입력하세요.');
					return;
				}
				$.ajax({
					type: 'post',
					url : '${contextPath}/comment/reply/add',
					data: $(this).closest('.frm_reply').serialize(), // 이건 사용 안 됩니다. $('.frm_reply').serialize(),
					dataType: 'json',
					success : function(resData){	// resData = {"isAdd", true}
						if(resData.isAdd){
							alert('답글이 등록되었습니다.');
							fn_commentList();  // 목록 갱신
							fn_commentCount(); // 개수 갱신
						}
					}
				});
			});
		};
	</script>
	
	
</div>

</body>
</html>