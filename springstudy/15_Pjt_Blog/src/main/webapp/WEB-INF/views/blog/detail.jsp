<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<jsp:include page="../layout/header.jsp">
	<jsp:param value="${blog.blogNo}번 블로그" name="title"/>
</jsp:include>

<div>

	<h1>${blog.title}</h1>
	
	<div>
		<span>▷ 작성일<fmt:formatDate value="${blog.createDate}" pattern="yyyy.M.d HH:mm"/></span>
		&nbsp;&nbsp;&nbsp;
		<span>▷ 수정일<fmt:formatDate value="${blog.modifyDate}" pattern="yyyy.M.d HH:mm"/></span>
	</div>
	<div>
		<span>조회수 <fmt:formatNumber value="${blog.hit}" pattern="#,##0"></fmt:formatNumber></span>
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
	
	<div>
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
	<script>
		fn_commentCount();
		fn_addComment();
		fn_commentList();
		
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
		}
		
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
		}
		
		function fn_commentList(){
			$.ajax({
				type:'get',
				url :'${contextPath}/comment/list',
				data:'blogNo=${blog.blogNo}&page=1',	// 페이징 처리를 위해, 현재 page도 파라미터로 전달!
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
							div += '<div style="margin-left: 40px;">;'
						}
						if (comment.state == 1) {
							div += '<div>' + comment.content + '</div>';
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
						div += '</div>';
						$('#comment_list').append(div);
						$('#comment_list').append('<div style="border-bottm: 1px dotted gray;"></div>')
					});
					// 페이징
					
				
				}
			});
		}
	</script>
	
	
</div>

</body>
</html>