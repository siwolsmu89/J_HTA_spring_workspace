package kr.co.jhta.step1;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.support.GenericXmlApplicationContext;

import kr.co.jhta.dao.BookDao;
import kr.co.jhta.vo.Book;

public class Main {

	public static void main(String[] args) throws SQLException {
		String conf = "classpath:/spring/context.xml";
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(conf);
		
		DataSource ds = ctx.getBean(DataSource.class);
		System.out.println("커넥션 풀 객체: " + ds);
		
		BookDao bd = ctx.getBean(BookDao.class);
		
		Book book = bd.getBookByNo(10013);
		
		System.out.println(book.getTitle());
		
		List<Book> books = bd.getAllBooks();
		for (Book b : books) {
			System.out.println(b.getTitle());
		}
	}
}
