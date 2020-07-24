package kr.co.jhta;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import kr.co.jhta.dao.UserDao;
import kr.co.jhta.vo.User;

public class Main {

	public static void main(String[] args) {
		String conf = "classpath:/spring/context.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(conf);
		
		UserDao userdao = ctx.getBean(UserDao.class);

		System.out.println("[사용자 관리]");
		try {
			while(true) {
				System.out.println("-----------------------------------------------------------------");
				System.out.println("1.전체 조회  2.조회(아이디)  3.조회(이름)  4.등록  5.삭제  6.전체삭제  0.종료");
				System.out.println("-----------------------------------------------------------------");
				Scanner sc = new Scanner(System.in);
				
				System.out.print("메뉴 선택> ");
				int menuNo = sc.nextInt();
				
				if (menuNo == 0) {
					ctx.destroy();
					
					System.out.println("<< 프로그램 종료 >>");
					break;
					
				} else if (menuNo == 1) {
					System.out.println("[전체 조회]");
					
					List<User> users = userdao.getAllUsers();
					
					if (users.isEmpty()) {
						System.out.println("조회된 사용자가 없습니다.");
					} else {
						System.out.println("---------------------");
						System.out.println("아이디  이름  이메일");
						System.out.println("---------------------");
						for (User user : users) {
							System.out.println(user.getId() + "  " + user.getName() + "  " + user.getEmail());
						}
					}
					System.out.println("<< 전체 사용자 조회 완료 >>");
					
				} else if (menuNo == 2) {
					System.out.println("[아이디로 조회]");
					System.out.print("아이디 입력> ");
					String id = sc.next();
					
					User user = userdao.getUserById(id);
					if (user == null) {
						System.out.println("조회된 사용자가 없습니다.");
					} else {
						System.out.println("아이디: " + user.getId());
						System.out.println("이  름: " + user.getName());
						System.out.println("이메일: " + user.getEmail());
					}
					
				} else if (menuNo == 3) {
					System.out.println("[이름으로 조회]");
					System.out.print("이름 입력> ");
					String name = sc.next();
					
					List<User> users = userdao.getUsersByName(name);
					if (users.isEmpty()) {
						System.out.println("조회된 사용자가 없습니다.");
					} else {
						System.out.println("---------------------");
						System.out.println("아이디  이름  이메일");
						System.out.println("---------------------");
						for (User user : users) {
							System.out.println(user.getId() + "  " + user.getName() + "  " + user.getEmail());
						}
					}
					System.out.println("<< 이름으로 조회 완료 >>");
					
				} else if (menuNo == 4) {
					System.out.println("[신규 사용자 등록]");
					System.out.print("아이디 입력> ");
					String id = sc.next();
					System.out.print("비밀번호 입력> ");
					String password = sc.next();
					System.out.print("이름 입력> ");
					String name = sc.next();
					System.out.print("이메일 입력> ");
					String email = sc.next();
					
					User user = new User();
					user.setId(id);
					user.setPassword(password);
					user.setName(name);
					user.setEmail(email);
					
					userdao.insertUser(user);
					System.out.println("<< 사용자 등록 완료 >>");
					
				} else if (menuNo == 5) {
					System.out.println("[아이디로 삭제]");
					System.out.print("아이디 입력> ");
					String id = sc.next();
					
					userdao.deleteUserById(id);
					System.out.println("<< 사용자 삭제 완료 >>");
					
				} else if (menuNo == 6) {
					System.out.println("[전체 삭제]");
					
					userdao.deleteAllUsers();
					System.out.println("<< 전체 사용자 삭제 완료 >>");
					
				}
			}
			
		} catch(DataAccessException e) {
			e.printStackTrace();
			
		}
			
	}
}
