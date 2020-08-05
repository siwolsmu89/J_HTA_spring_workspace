package kr.co.jhta.web;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.form.UserForm;
import kr.co.jhta.service.UserService;
import kr.co.jhta.vo.User;

@Controller
@RequestMapping("/signup.do")
public class SignupController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String form(Model model) {
		// 폼 입력값 저장 및 검증을 위해 유효성 체크 어노테이션이 부착된 UserForm 객체를 생성하고, Model에 저장한다. 
		UserForm userForm = new UserForm();
		userForm.setBirth(new Date());
		model.addAttribute("userForm", userForm);
		return "form";
	}
	
	@PostMapping
	public String signUp(@ModelAttribute("userForm") @Valid UserForm userForm, BindingResult errors) {
		
		// 아이디 중복 체크
		if (userService.getUserDetail(userForm.getId()) != null) {
			errors.rejectValue("id", null, "이미 사용중인 아이디입니다.");
			return "form";
		}

		// 유효성 검사결과 에러가 있었는지 확인하기
		System.out.println("유효성 체크결과 에러가 발견되었는가? " + errors.hasErrors());
		if (errors.hasErrors()) {
			return "form";	// 입력화면으로 내부이동하기
		}
		
		// 회원가입 처리
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		userService.addNewUser(user);
		
		return "redirect:/home.do";
	}
}
