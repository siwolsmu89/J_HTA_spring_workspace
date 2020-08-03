package kr.co.jhta.form;

import org.springframework.web.multipart.MultipartFile;

// 폼 커맨드 객체
// * 폼 커맨드 객체는 입력필드의 값을 저장하기 위해서 생성한 객체이다.
// * <form /> 태그에서 정의한 모든 입력필드 값을 한 번에 담기 위해서 사용한다.
// * 요청핸들러 메소드에서 폼 커맨드 객체를 매개변수로 선언하면, 
//   HandlerAdapter가 
//		1. 폼 커맨드 객체를 생성한다. (default 생성자가 꼭 필요하다.)
//		2. 폼 커맨드 객체의 필드명을 검색한다.
//		3. 폼 커맨드 객체의 필드명과 동일한 이름의 요청파라미터 값을 요청객체에서 조회한다.
//		4. 조회된 값을 폼 커맨드 객체의 필드에 저장한다.
//		   (기본 자료형 타입, String 타입 등의 경우, 필요하다면 형 변환을 수행한다.)
//		5. 모든 요청파라미터 값의 저장이 완료되면, 요청 핸들러 메소드를 실행하면서 매개변수로 폼 커맨드 객체를 전달한다.
public class BoardForm {

	private String title;
	private String writer;
	private String content;
	private MultipartFile upfile;
	private String password;
	
	public BoardForm() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public MultipartFile getUpfile() {
		return upfile;
	}

	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}