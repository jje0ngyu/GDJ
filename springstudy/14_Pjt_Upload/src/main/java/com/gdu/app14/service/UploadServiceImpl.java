package com.gdu.app14.service;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app14.domain.AttachDTO;
import com.gdu.app14.domain.UploadDTO;
import com.gdu.app14.mapper.UploadMapper;
import com.gdu.app14.util.MyFileUtil;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	private UploadMapper uploadMapper;
	@Autowired
	private MyFileUtil myFileUtil;
	
	@Override
	public List<UploadDTO> getUploadList() {
		return uploadMapper.selectUploadList();
	}
	
	@Transactional	// 업로드에 insert, attachCnt에 insert (2번 insert 해서)
	@Override
	public void save(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		
		/* 업로드 테이블에 저장하기 */
		// 파라미터
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		
		// DB로 보낼 UploadDTO
		UploadDTO upload = UploadDTO.builder()
				.title(title)
				.content(content)
				.build();
		
//		System.out.println(upload); // uploadNo 없음
		// DB에 UploadDTO 저장
		int uploadResult = uploadMapper.insertUpload(upload);
		// * <selectKEY>에 의해 upload 에 uploadNo 값도 입력된 상태.
		// * uploadNo = UPLOAD_SEQ.NEXTVAL 의 값
//		System.out.println(upload); // uploadNo 있음 
		
		
		/* ATTACH 테이블에 저장하기 */
		// 첨부된 파일 목록
		List<MultipartFile> files = multipartRequest.getFiles("files");
		
		// 첨부 결과
		int attachResult;
		if(files.get(0).getSize() == 0) { // 첨부가 없는 경우 (files 리스트에 
		// [MultipartFile[field="files", filename=, contextType=application/octet-stream. size=0]] 이렇게 저장되어 있어서 files.size()가 1이다.
			attachResult = 1;
		} else {	
			attachResult = 0;
		}
			
		// 첨부된 파일 목록 순회 (하나씩 저장)
		for(MultipartFile multipartFile : files) {
			try {
				// 첨부가 있는지 점검
				if (multipartFile != null && multipartFile.isEmpty() == false) {	// 둘 다 필요
					// 원래 이름
					String origin = multipartFile.getOriginalFilename();
					origin = origin.substring(origin.lastIndexOf("\\") + 1);	// IE는 origin에 전체 경로가 붙어서 파일명만 사용해야 한다.
				
					// 저장할 이름
					String filesystem = myFileUtil.getFilename(origin);
					// 저장할 경로
					String path = myFileUtil.getTodayPath();
					// 저장할 경로 만들기
					File dir = new File(path);
					if(dir.exists() == false) {
						dir.mkdirs();
					}
					// 첨부할 파일 객체
					File file = new File(dir, filesystem);
					// 첨부파일 서버에 저장(업로드 진행)
					multipartFile.transferTo(file);
					
					//AttachDTO 생성( 첨부파일 정보 )
					AttachDTO attach = AttachDTO.builder()
							.path(path)
							.origin(origin)
							.filesystem(filesystem)
							.uploadNo(upload.getUploadNo())
							.build();
					// DB에 AttachDTO 저장
					// (* for문을 사용할 경우, 첨부된 갯수와 attachResult의 값이 일치해야 모두 성공한 것이다.)
					attachResult += uploadMapper.insertAttach(attach);
							
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}// for
		// 응답
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			if (uploadResult > 0 && attachResult == files.size()) {
				out.println("<script>");
				out.println("alert('업로드 되었습니다.');");
				out.println("location.href='" +  multipartRequest.getContextPath() + "/upload/list';");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('업로드에 실패했습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
