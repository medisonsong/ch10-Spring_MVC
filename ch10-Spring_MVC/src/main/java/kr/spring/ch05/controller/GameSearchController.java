package kr.spring.ch05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.ch05.service.SearchService;
import kr.spring.ch05.vo.SearchVO;

@Controller
public class GameSearchController {
	@Autowired //set메서드 생략 가능(Autowired가 자동으로 생성해줌)
	private SearchService searchService; 
	
	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main";
	}
	
	@RequestMapping("/search/game.do")
	public ModelAndView search(SearchVO searchVO) { //@ModelAttribute 생략
		
		System.out.println("검색어 : " + searchVO.getQuery());
		
		//searchService호출해서 검색완료라는 결과값 가져오기
		String result = searchService.search(searchVO);
		
		ModelAndView mav = new ModelAndView();
		//뷰이름 지정
		mav.setViewName("search/game");
		//뷰에 전달할 데이터 지정
		mav.addObject("result", result);
		
		return mav;
	}
}
