package kr.co.jhta.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 인증여부를 체크하는 인터셉터
// 이미 가입했고, 정상적인 로그인 과정을 통과한 사용자
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("사용자에 대한 인증여부를 체크합니다.");
		return true;
	}
}
