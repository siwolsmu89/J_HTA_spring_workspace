package kr.co.jhta.di.service.step1;

import kr.co.jhta.di.service.ConsoleOutput;

public class Reporter {
	
	// 화면출력을 지원하는 ConsoleOutput 객체를 생성함
	private ConsoleOutput consoleOutput = new ConsoleOutput();
	
	public void report(String title, String text) {
		consoleOutput.write("제목 :" + title);
		consoleOutput.write("내용 :" + text);
	}
}
