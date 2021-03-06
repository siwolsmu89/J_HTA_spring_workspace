package kr.co.jhta.di.service.step5;

import kr.co.jhta.di.service.Output;

public class Reporter {
	
	private Output output;
	
	// Output 객체를 전달받는 setter 메소드
	public void setOutput(Output output) {
		this.output = output;
	}
	
	// 기본 생성자
	public Reporter() {
		System.out.println("객체 생성 후 기본 생성자가 실행됨");
	}
	
	// Output 객체를 전달받는 생성자
	public Reporter(Output output2) {
		System.out.println("기본 생성자가 아닌 생성자가 실행됨");
		this.output = output2;
	}
	
	// 핵심 기능 구현
	public void report(String title, String text) {
		output.write("제목: " + title);
		output.write("내용: " + text);
	}
}
