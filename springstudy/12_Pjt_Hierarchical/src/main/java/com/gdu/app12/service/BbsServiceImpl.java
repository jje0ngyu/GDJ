package com.gdu.app12.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app12.domain.BbsDTO;
import com.gdu.app12.mapper.BbsMapper;
import com.gdu.app12.util.PageUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BbsServiceImpl implements BbsService {

	// 필드가 2개 이상일 땐 @Autowired 말고 @AllArgsConstructor 사용하는 것이 좋다. (오토와이어드는 생성자마다 붙여줘야함)
	private BbsMapper bbsMapper;
	private PageUtil pageUtil;
	
	@Override
	public void findAllBbsList(HttpServletRequest request, Model model) {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		// 전체 게시글 개수
		int totalRecord = bbsMapper.selectAllBbsCount();
		
		// 파라미터 recordPerPage, 전달되지 않으면 recordPerPage=10으로 처리
		Optional<String> opt2 = Optional.ofNullable(request.getParameter("recordPerPage"));
		int recordPerPage = Integer.parseInt(opt2.orElse("10"));
		
		// 페이징에 필요한 모든 계산 완료
		pageUtil.setPageUtil(page, totalRecord, recordPerPage);
		
		// DB로 보낼 Map(begin + end)
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		
		// DB에서 목록 가져오기
		List<BbsDTO> bbsList = bbsMapper.selectAllBbsList(map);
		
		// 뷰로 보낼 데이터
		model.addAttribute("bbsList", bbsList);
		model.addAttribute("paging" ,pageUtil.getPaging(request.getContextPath() + "/bbs/list"));
		model.addAttribute("beginNo", totalRecord - (page-1) * pageUtil.getRecordPerPage());
		model.addAttribute("recordPerPage", recordPerPage);
	}

	@Override
	public int addBbs(HttpServletRequest request) {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String ip = request.getRemoteAddr();
		
		BbsDTO bbsDTO = new BbsDTO();
		bbsDTO.setWriter(writer);
		bbsDTO.setTitle(title);
		bbsDTO.setIp(ip);
		
		return bbsMapper.insertBbs(bbsDTO);
	}

	@Override
	public int addReply(HttpServletRequest request) {
		
		return 0;
	}

	@Override
	public int removeBbs(int bbsNo) {
		return bbsMapper.deleteBbs(bbsNo);
	}

}
