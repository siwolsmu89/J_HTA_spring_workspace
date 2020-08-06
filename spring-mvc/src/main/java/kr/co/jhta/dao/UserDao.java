package kr.co.jhta.dao;

import java.util.List;

import kr.co.jhta.vo.User;

public interface UserDao {

	void insertUser(User user);
	User getUserById(String userId);
}
	
