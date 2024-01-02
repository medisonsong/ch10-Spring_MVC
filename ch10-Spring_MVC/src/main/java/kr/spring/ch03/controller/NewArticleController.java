package kr.spring.ch03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.ch03.vo.NewArticleVO;

@Controller
public class NewArticleController {
	
	//Get 요청이 들어올 때 호출
	@GetMapping("/article/newArticle.do")
	public String form() { 
		return "article/newArticleForm"; 
	}
	
	//Post 요청이 들어올 때 호출
	@PostMapping("/article/newArticle.do")
	public String submit(
			@ModelAttribute("vo") NewArticleVO newArticleVO) {
		
		return "article/newArticleSubmitted";
	}
}
