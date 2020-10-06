package baekhwa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import baekhwa.domain.dto.BoardDto;
import baekhwa.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	//리스트페이지
	@GetMapping("/board/list/1")
	public String list(BoardDto dto, Model model) {
		List<BoardDto> list = service.list(dto);
		model.addAttribute("boardList", list);
		return"/board/list";
	}
	
	//글쓰기페이지
	@GetMapping("/board/write")
	public String write() {
		return"/board/write";
	}
	
	//글쓰기처리
	@PostMapping("/board/write")
	public String write(BoardDto dto, HttpServletRequest request) {
		dto.setUser_ip(request.getRemoteAddr());
		service.insert(dto);
		
		return"redirect:/board/list/1";
	}
	
	//디테일페이지
	@GetMapping("/board/{no}")
	public String detail(@PathVariable int no, Model model) {
		BoardDto dto = service.detail(no);
		model.addAttribute("dto", dto);
		return"/board/detail";
	}
	
	//수정페이지
	@PostMapping("/board/edit")
	public String edit(BoardDto dto) {
		service.update(dto);
		return"redirect:/board/"+dto.getNo();
	}
	
	//삭제페이지
	@GetMapping("/board/delete/{no}")
	public String delete(@PathVariable int no) {
		service.delete(no);
		return"redirect:/board/list/1";
	}
	

}
