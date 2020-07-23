package kr.co.jhta.di.service.step6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		String conf = "kr/co/jhta/di/service/step6/context-step6.xml";
		
		ApplicationContext ctx = new GenericXmlApplicationContext(conf);
		
		Reporter reporter = ctx.getBean("reporter", Reporter.class);
		
		reporter.report("제목입니다", "내용입니다.");
		
	}
}
