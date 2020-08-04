package com.project.portfolio;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	/*
	 * 1. 모든 주소는 'container.jsp'를 호출하도록 지정
	 * 2. container.jsp 내부에는 <%@ include file="${contentLocation }" %> 태그로 변동되는 페이지를 지정된 div 내부에 출력하도록 설정되어 있음
	 * 3. model에 addAttribute() 메소드를 사용해서contentLocation 주소를 @RequestMapping에 해당하는 실제 페이지로 설정해서 반환
	 * 
	 * contentLocation 페이지가 고장나더라도 container.jsp 자체는 실행되지 않을까 싶은데 그건 모르겠네용ㅎ
	 * 
	 * 아래 예시 - /community/main.do 요청이 왔을 때
	 * return String은 'container' (실질적으로는 /경로/container.jsp가 되겠죠)
	 * 내부에 contentLocation = '../community/main.jsp'라는 jsp파일 경로를 작성해 모델에 저장 
	 * (경로 기준은 container가 될 것이므로 ../ 를 사용하든 절대경로를 적든 해야 함)
	 * 
	 * 이런식으로 하면 될거같은데 실험은 안해봄
	 * 
	 * 사이드바는 model의 Attribute가 아니라 session 단위로 올려주면 매번 로딩하는 수고를 줄일 수 있을 듯
	 * 그리고 적절한 경로가 없을 때를 대비한 default 페이지를 @ModelAttribute에 하나 달아놔도 좋을 것 같습니다.
	 * 
	 * @민석
	 */

	
//	@SessionAttributes("sidebarLocation")
//  public .... method 하나 만들고
//  여기서 sidebar 주소 설정 (사이드바는 controller 내부의 주소들끼리는 동일한 사이드바를 공유할 것이므로)
	
	
	
// 개별 요청에 대한 처리 방식 예시
	@RequestMapping(value = "/community/main.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("contentLocation", "../community/main.jsp");
		
		return "container";
	}
	
}
