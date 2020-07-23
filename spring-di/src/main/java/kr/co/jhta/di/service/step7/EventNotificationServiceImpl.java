package kr.co.jhta.di.service.step7;

import java.util.List;

import kr.co.jhta.di.service.MessageSender;
import kr.co.jhta.di.vo.User;

public class EventNotificationServiceImpl implements EventNotificationService{
	
	// 인터페이스 - XXX류(범용적)
	private MessageSender messageSender;
	private UserService userService;
	
	// 주입받는것 제외하고 정의하지 말것
	// private User user;
	// 값은 DB에서 가져오거나 파라미터로 받는다.
	
	// 객체 조립을 위한 짹
	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void noticeEvent(String eventName, String eventContent) {
		List<User> users = userService.getAllUser();
		for(User user : users) {
			messageSender.send("coders9", user.getTel(), eventName, eventContent);
		}
		
	}
}
