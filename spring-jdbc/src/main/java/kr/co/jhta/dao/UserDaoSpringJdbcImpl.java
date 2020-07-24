package kr.co.jhta.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import kr.co.jhta.vo.User;

public class UserDaoSpringJdbcImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("jdbcTemplate 설정됨");
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void insertUser(User user) {
		String sql = "INSERT INTO spring_users (user_id, user_name, user_password, user_email) ";
		sql += "VALUES (?, ?, ?, ?) ";
		
		int result = jdbcTemplate.update(sql, user.getId(), user.getName(), user.getPassword(), user.getEmail());
		System.out.println("spring_users 테이블에 " + result + "개의 행 삽입 완료.");
	}
	
	@Override
	public void updateUser(User user) {
		String sql = "UPDATE spring_users ";
		sql += "SET user_name = ?, user_password = ?, user_emal = ? ";
		sql += "WHERE user_id = ? ";
		
		jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getEmail(), user.getId());
		
	}
	
	@Override
	public void deleteAllUsers() {
		String sql = "DELETE FROM spring_users";
		
		jdbcTemplate.update(sql);
	}
	
	@Override
	public void deleteUserById(String userId) {
		String sql = "DELETE FROM spring_users WHERE user_id = ? ";
		
		int result = jdbcTemplate.update(sql, userId);
		System.out.println("spring_users 테이블에서 " + result + "개의 행 삭제 완료.");
	}
	
	@Override
	public User getUserById(String userId) {
		String sql = "SELECT user_id, user_name, user_password, user_email FROM spring_users WHERE user_id = ?";
		return jdbcTemplate.queryForObject(sql, new UserRowMapper(), userId);
	}
	
	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM spring_users ORDER BY user_id ASC ";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}
	
	@Override
	public List<User> getUsersByName(String username) {
		String sql = "SELECT * FROM spring_users WHERE user_name = ? ORDER BY user_id ASC ";
		return jdbcTemplate.query(sql, new UserRowMapper(), username);
	}
	
	class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			
			user.setId(rs.getString("user_id"));
			user.setName(rs.getString("user_name"));
			user.setPassword(rs.getString("user_password"));
			user.setEmail(rs.getString("user_email"));
			
			return user;
		}
	}
}
