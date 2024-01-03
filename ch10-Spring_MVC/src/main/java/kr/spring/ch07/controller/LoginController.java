package kr.spring.ch07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login/login.do")
	public String form() {
		return "login/form";
	}
}
