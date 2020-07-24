package kr.co.jhta.step2;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.co.jhta.dao.BookDao;
import kr.co.jhta.vo.Book;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		String conf = "classpath:/spring/context.xml";
		ApplicationContext ctx = new GenericXmlApplicationContext(conf);
		
		BookDao bd = ctx.getBean(BookDao.class);
		List<Book> books = bd.getAllBooks();
		for (Book b : books) {
			System.out.println(b.getNo() + " | " + b.getTitle());
		}
	}
}
