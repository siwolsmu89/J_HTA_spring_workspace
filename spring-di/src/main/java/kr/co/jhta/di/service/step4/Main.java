package kr.co.jhta.di.service.step4;

public class Main {
	
	public static void main(String[] args) {
		Factory factory = new Factory();
		Reporter reporter = factory.getBean("reporter", Reporter.class);
		reporter.report("의존성 주입", "설정파일을 이용한 객체 생성 및 조립");
	}
}
