package kr.co.jhta.di.service.step8;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main_map {

	public static void main(String[] args) {
		String conf = "kr/co/jhta/di/service/step8/context-step8-map.xml";
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(conf);
		
		NoticeServiceUsingMap noticeServiceUsingMap = ctx.getBean("noticeServiceUsingMap", NoticeServiceUsingMap.class);
		
		noticeServiceUsingMap.notice("경리팀", "급여삭감 안내", "임원급 이상 직원의 급여를 20% 삭감합니다.");
		
		ctx.destroy();

	}

}
