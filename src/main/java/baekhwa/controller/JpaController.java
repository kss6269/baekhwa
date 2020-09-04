package baekhwa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import baekhwa.domain.dto.JpaBoardRequestDto;
import baekhwa.service.JpaBoardService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class JpaController {
	
	@Autowired
	private JpaBoardService service;
	
	@GetMapping("/jpa/list")
	public String list() {
		return "/jpa/list";
	}
	
	@GetMapping("/jpa/write")
	public String write() {
		return "/jpa/write";
	}
	
	@PostMapping("/jpa/write")
	public String write(JpaBoardRequestDto dto, HttpServletRequest request) {
		dto.setUser_ip(request.getRemoteAddr());//user_ip셋팅
		log.debug(dto);
		
		service.save(dto);
		
		return "redirect:/jpa/list";
	}

}
