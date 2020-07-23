package kr.co.jhta.di.service.step1;

import kr.co.jhta.di.service.ConsoleOutput;
import kr.co.jhta.di.service.FileOutput;

public class Reporter {
	
	// 화면출력을 지원하는 ConsoleOutput 객체를 생성함
	// private ConsoleOutput consoleOutput = new ConsoleOutput();
	
	// 콘솔이 아니라 파일에 출력하는 FileOutput 객체를 생성함
	private FileOutput fileOutput = new FileOutput("C:/temp", "sample.txt");
	
	public void report(String title, String text) {
//		consoleOutput.write("제목 :" + title);
//		consoleOutput.write("내용 :" + text);
		
		// 의존하는 객체를 바꾸면 소스 전체가 바뀐다.
		fileOutput.write("제목 :" + title);
		fileOutput.write("내용 :" + text);
	}
}
