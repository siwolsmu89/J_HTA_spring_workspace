package kr.co.jhta.di.step2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String conf = "classpath:/spring/context-step2.xml";
		ApplicationContext ctx = new GenericXmlApplicationContext(conf);
		AlarmServiceImpl asi = ctx.getBean(AlarmServiceImpl.class);
		
		asi.alarm("기상");
	}
}
