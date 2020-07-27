package kr.co.jhta.dao;

import java.util.List;

import kr.co.jhta.vo.User;

public class UserDao {

	// INSERT: N종류의 데이터, parameter: User
	public void insertUser(User user) {
		
	}
	
	// DELETE: 없음, parameter: 없음
	public void deleteAllUsers() {
		
	}
	
	// DELETE: 기본자료형(String 포함), parameter: string
	public void deleteUserById() {
		
	}

	// UPDATE: N 종류의 데이터, parameter: User
	public void updateUser(User user) {
		
	}
	
	// SELECT: N행 N열, parameter: 없음, result: User, 최종값: List<User>
	public List<User> getAllUsers() {
		return null;
	}
	
	// SELECT: N행 N열, parameter: string, result: User, 최종값: List<User>
	public List<User> getUserByName(String userName) {
		return null;
	}
	
	// SELECT: 1행 N열, parameter: string, result: User, 최종값: User 객체
	public User getUserById(String userId) {
		return null;
	}
	
	// SELECT: 1행 N열, parameter: string, result: User, 최종값: User 객체
	public User getUserByEmail(String userEmail) {
		return null;
	}
	
	// SELECT: 1행 1열, parameter: 없음, result: int, 최종값: int
	public int getUsersCount() {
		return 0;
	}
}
