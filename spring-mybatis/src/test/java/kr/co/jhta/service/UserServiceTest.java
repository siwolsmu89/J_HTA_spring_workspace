package kr.co.jhta.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.jhta.dao.UserDao;
import kr.co.jhta.vo.User;

/*
 * @ContextConfiguration
 * 		- 테스트 대상 객체가 정의되어 있는 스프링 빈 설정파일의 경로를 지정하는 어노테이션이다.
 * 		- (locations = "classpath:/설정파일 경로")에 지정된 설정파일을 읽어온다.
 * @RunWith
 * 		- JUnit 테스트가 실행될 때 같이 실행될 Helper 클래스를 지정하는 어노테이션이다.
 * SpringJUnit4ClassRunner
 * 		- JUnit을 활용한 단위테스트 실행 시 같이 실행되는 Helper 클래스다.
 * 		- @ContextConfiguration으로 지정된 설정파일을 읽어서 객체를 생성/조립하는 스프링 컨테이너를 생성한다.
 * 		- @Autowired 어노테이션을 사용하여 테스트 대상 객체를 주입받을 수 있도록 지원한다. 
 */
@ContextConfiguration(locations = "classpath:/spring/context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	@Autowired
	UserService userService;
	@Autowired
	UserDao userDao;
	
	@Test
	public void testConfiguration() {
		
		System.out.println(userService);
		assertNotNull(userService);
	}
	
	@Test
	public void testAddNewUser() {
		User user = new User("kimkimlee", "김김이", "zxcv1234", "kkim@gmail.com");
		userService.addNewUser(user);
		
		User savedUser = userDao.getUserById(user.getId());
		assertNotNull(savedUser);
		assertEquals("김김이", savedUser.getName());
	}
}
