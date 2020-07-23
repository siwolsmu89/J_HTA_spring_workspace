package kr.co.jhta.step1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.jhta.sender.KakaotalkMessageSender;
import kr.co.jhta.sender.MessageSender;
import kr.co.jhta.service.EventServiceImpl;

@Configuration
public class JavaConfig {
	
	/*
	 * Spring bean configuration 파일에서 아래 태그를 작성한 것과 동일한 설정을 자바코드로 정의한 것이다.
	 * <bean id="messageSender" class="kr.hta.sender.KakaotalkMessageSender"></bean>
	 */
	@Bean
	public MessageSender messageSender() {
		return new KakaotalkMessageSender();
	}
	
	/*
	 * <bean id="eventService" class="kr.co.jhta.service.EventServiceImpl">
	 * 	<property name="messageSender" ref="messageSender"></property>
	 * </bean>
	 */
	@Bean
	public EventServiceImpl eventService(MessageSender messageSender) {
		EventServiceImpl eventServiceImpl = new EventServiceImpl();
		eventServiceImpl.setMessageSender(messageSender);
		
		return eventServiceImpl;
	}
}
