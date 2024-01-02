package kr.spring.ch02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	/*
	 * @RequestParam 어노테이션은 HTTP 요청 파라미터를 메서드의 파라미터로 전달
	 * [형식]
	 * 1. @RequestParam(요청파라미터네임) 메서드의 인자(파라미터)
	 * 		요청파라미터를 필수적으로 사용하지 않으면 오류 발생
	 * 		아래오 같이 required는 false로 지정하면 요청파라미터가 없어도 오류 발생하지 않음
	 * 		@RequestParam(value="query",required=false)
	 * 		[데이터가 숫자일 경우]
	 * 		@RequestParam(value="p", required=false) Integer pageNumber
	 * 		요청파라미터의 값이 없을 경우 null 처리
	 * 		타입이 Integer가 아니라 int일 경우 오류가 발생하기 때문에 
	 * 		@RequestParam(value="p" defaultValue="1") int pageNumber
	 * 		기본값을 지정해서 기본값이 인자에 전달되도록 처리
	 * 
	 * 2. 요청파라미터명과 호출메서드의 인자명이 같으면 
	 * 		요청파라미터명 생략 가능 -> @RequestParam String query (어노테이션+메서드인자명)
	 * 
	 * 3. @RequestParam 생략 가능
	 * 		요청파라미터명과 호출메서드의 인자명을 동일하게 표기
	 * 		query를 필수적으로 사용하지 않아도 오류가 발생하지 않음
	 */
	//요청URL과 실행 메서드 연결
	@RequestMapping("/search/internal.do") //하위 경로를 만들수도 있음
	public ModelAndView searchInternal(String query) {
		
		System.out.println("query = " + query);
		
		ModelAndView mav = new ModelAndView();
		//뷰 이름 지정
		mav.setViewName("search/internal");
		//뷰에서 호출할 데이터 저장
		mav.addObject("query", query);
		
		return mav;
	}
	
	@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(
			@RequestParam(value="query", required=false) String query,
			@RequestParam(value="p", defaultValue="1") int pageNumber) {//타입이 다르지만 정보를 받을 수 있음
		
		System.out.println("query = " + query);
		System.out.println("p = " + pageNumber);
		
		ModelAndView mav = new ModelAndView();
		//뷰이름 지정
		mav.setViewName("search/external");
		//뷰에 전달할 데이터 (request에 저장)
		mav.addObject("query", query);
		mav.addObject("pageNumber", pageNumber);
		
		return mav;
	}
}
