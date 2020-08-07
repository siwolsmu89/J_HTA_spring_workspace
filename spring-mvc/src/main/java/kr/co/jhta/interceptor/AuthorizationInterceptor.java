package kr.co.jhta.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 인증된 사용자가 해당 페이지에 대한 접근권한을 가지고 있는지 체크한다.
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("사용자에 대한 페이지 접근 권한 소유 여부를 체크합니다.");
		return true;
	}
}
