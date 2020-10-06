package baekhwa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

import baekhwa.domain.dto.UserRequestDto;
import baekhwa.service.UserService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	HttpSession session;
	
	
	//회원가입 페이지
	@GetMapping("/user/signup")
	public String join() {
		return"/sign/join";
	}
	
	//회원가입처리
	@PostMapping("/user/signup")
	public ModelAndView join(UserRequestDto dto) {
		ModelAndView mv = service.save(dto);
		return mv;
	}
	
	//로그인페이지
	@GetMapping("/user/login")
	public String login() {
		return"/sign/login";
	}
	
	//로그인처리
	@PostMapping("/user/login")
	public ModelAndView login(UserRequestDto dto) {
		ModelAndView mv = service.login(dto);
		return mv;
	}
	
	//로그아웃
	@GetMapping("/user/logout")
	public String logout() {
		session.removeAttribute("user");
		return"redirect:/";
	}
	
	
	/*
	@GetMapping("/user/signup")
	public String join() {
		return"/sign/join";
	}
	
	@PostMapping("/user/signup")
	public ModelAndView join(UserRequestDto dto) {
		ModelAndView mv = service.save(dto);
		mv.setViewName("/sign/login");
		return mv;
	}
	
	@GetMapping("/user/login")
	public String login() {
		return"/sign/login";
	}
	
	@PostMapping("/user/login")
	public ModelAndView login(UserRequestDto dto) {
		//ModelAndView mv = service.login(dto);
		return service.login(dto);
	}
	
	@GetMapping("/user/logout")
	public String logout() {
		service.logout();
		return"redirect:/";
	}
	*/

}
