package kr.co.jhta.di.service.step7;

import java.util.ArrayList;
import java.util.List;

import kr.co.jhta.di.vo.User;

public class UserServiceImpl implements UserService {
	
	@Override
	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();
		
		users.add(new User("hong", "홍길동", "010-1111-1111", "sms"));
		users.add(new User("lee", "이길동", "010-2222-2222", "katalk"));
		users.add(new User("kim", "김길동", "010-3333-3333", "sms"));
		users.add(new User("park", "박실동", "010-5555-5555", "sms"));
		users.add(new User("shim", "심길동", "010-9999-9999", "katalk"));
		
		return users;
	}
}
