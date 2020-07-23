package kr.co.jhta.di.step2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.di.MessageSender;

@Service
public class AlarmServiceImpl implements AlarmService {
	
	@Autowired
	MessageSender messageSender;
	
	@Override
	public void alarm(String message) {
		messageSender.send("민방위본부", "전국민", "비상사태", message);
	}
}
