<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 요청 파라미터
	request.setCharacterEncoding("UTF-8");
	String createdDate = request.getParameter("created_date");
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	// 작성자 IP
	String ip = request.getRemoteAddr();	//* 작성자 IP주소
	
	// 파일명
	// 작성자IP_작성자.txt
	
	// IPv4
	// 127.0.0.1
	// 127_0_0_1 	replaceAll("\\.", "_")
	
	// IPv6
	// 0:0:0:0:0:0:0:1
	// 0_0_0_0_0_0_0_1 	replaceAll(":", "_")

	String filename = ip.replaceAll(":", "_").replaceAll("\\.", "_") + "_" + writer + ".txt";
	
	// 파일 경로
	String realPath = application.getRealPath("storage" + File.separator + createdDate);
	//* ServletContext는 application로 변환
	//* separator은 실행하는 시스템(윈도우/리눅스)에 따라 (역슬래시(\), 슬래시(/))를 사용하도록 하는 것이다.
	File dir = new File(realPath);
	if(dir.exists() == false){
		dir.mkdirs();
	}
	
	// 생성할 파일 객체
	//* 저장할 txt파일의 위치(dir)와 이름(filename) 지정하기
	File file = new File(dir, filename);
	
	// 문자 출력 스트림 생성
	//* 브라우저에 작성된 글자내용을 txt파일로 내려받기
	BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	bw.write("작성일자 : " + createdDate + "\n");
	bw.write("작성자 : " + writer + "\n");
	bw.write("제목 : " + title + "\n");
	bw.write("내용\n" + content + "\n");
	bw.close();
%>
<script>
	var isCreated = <%=file.exists()%>;
	if(isCreated){
		alert('<%=filename%>파일이 생성되었습니다.');
	} else {
		alert('파일이 생성되지 않았습니다.');
	}
	history.back();
	// 뒤로 이동 (작성 페이지로 돌아가기)
	//* history.back()이 있으면, button submit 후에 페이지에 그대로 남아있는다.
	
</script>