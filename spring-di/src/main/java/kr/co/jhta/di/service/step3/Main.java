package kr.co.jhta.di.service.step3;

import kr.co.jhta.di.service.ConsoleOutput;
import kr.co.jhta.di.service.FileOutput;

public class Main {
	
	public static void main(String[] args) {
		/*
		 *	 1. Reporter 객체는 더이상 자신이 의존하는 객체를 생성하지 않는다.
		 *	 2. Reporter 객체는 어떤 종류의 객체가 필요한지만 정의하고, 필요한 객체를 전달받는 setter 메소드를 가지고 있다.
		 *	 3. Reporter의 주요 기능을 사용하기 위해서는 반드시 Reporter 객체가 의존하는 객체를 제공해 줄 필요가 있다.
		 *	 4. Reporter 객체는 더이상 의존하는 객체에 대한 생성 책임이 없어지고, 
		 *	 	Reporter 객체를 이용하는 제 3자 객체에게 Reporter 객체가 의존하는 객체 생성 및 해당 객체를 Reporter 객체에 전달하는 책임이 발생한다.
		 */
		
		// 프로그램 실행에 필요한 객체 생성
		Reporter reporter = new Reporter();
		FileOutput fileOutput = new FileOutput("c:/temp", "step3.txt");
		ConsoleOutput consoleOutput = new ConsoleOutput();
		
		// 프로그램 실행에 필요한 객체 조립 (Reporter 객체에게 의존성이 주입됨)
		reporter.setOutput(consoleOutput);
		// reporter.setOutput(fileOutput);

		// 실제 작업 수행
		reporter.report("인터페이스 의존", "의존하는 객체를 직접 생성하지 않는다.");
	}
}
