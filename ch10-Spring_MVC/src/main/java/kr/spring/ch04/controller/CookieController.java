package kr.spring.ch04.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	
	//쿠키 생성하는 메서드
	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse response) {

		//쿠키를 생성해서 클라이언트에 전송
		response.addCookie(new Cookie("auth","1"));
		
		return "cookie/make"; //cookie=뷰경로/make=뷰이름
	}
	
	/*
	 * @CookieValue 어노테이션을 이용하면 쿠키 값을 파라미터로 전달받을 수 있음
	 * [형식]
	 * @CookieValue("쿠키명") String auth
	 * 해당 쿠키가 존재하지 않으면 기본적으로 404 에러 발생
	 * @CookieValue(value="쿠키명",required=false) 또는
	 * @CookieValue(value="쿠키명",defaultValue="0") 명시 가능
	 */
	
	//쿠키 읽는 메서드
	@RequestMapping("/cookie/view.do")
	public String view(@CookieValue(value="auth", defaultValue="0") String auth) { //auth:쿠키명
		
		System.out.println("auth 쿠키 : " + auth);
		
		return "cookie/view";
	}
}
