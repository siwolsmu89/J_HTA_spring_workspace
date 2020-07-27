package kr.co.jhta.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	/*
	 * mybatis의 주요 API
	 * 		- SqlSession
	 * 			매퍼파일에 정의된 SQL문을 실행하는 객체다.
	 * 			int 	insert(String id)
	 * 			int 	insert(String id, Object parameter)
	 * 			int 	update(String id)
	 * 			int 	update(String id, Object parameter)
	 * 			int 	delete(String id)
	 * 			int 	delete(String id, Object parameter)
	 * 			Object 	selectOne(String id)
	 * 			Object 	selectOne(String id, Object parameter)
	 * 			List 	selectList(String id)
	 * 			List 	selectList(String id, Object parameter)
	 * 			void	close()
	 * 			void	commit()
	 * 			void	rollback()
	 * 			주의사항 )
	 * 				SqlSession은 일회용 객체다. 
	 * 				쿼리를 한 번 실행할 때마다 SqlSessionFactory로부터 새로운 SqlSession 객체를 획득해서 사용하고, 폐기한다.
	 * 
	 * 		- SqlSessionFactory
	 * 			쿼리 실행에 필요한 SqlSession 객체를 제공하는 객체다.
	 * 			애플리케이션이 실행되는 동안 딱 한 번만 생성해서 계속 사용한다.
	 * 			Connection을 미리 생성하고 연결해 주는 Connection Pool과 비슷한 개념이라고 생각해도 무방하다.
	 * 			SqlSession openSession()
	 * 				* 새로운 SqlSession 객체를 반환한다.
	 * 
	 * 		- SqlSessionFactoryBuilder
	 * 			mybatis 환경설정 정보를 이용해서 SqlSessionFactory 객체를 생성한다.
	 * 			SqlSessionFactory build(InputStream inputStream)
	 * 
	 */
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "mybatis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
