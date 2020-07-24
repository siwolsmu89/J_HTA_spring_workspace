package kr.co.jhta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.co.jhta.vo.Book;

public class BookDao {

	private DataSource ds;
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	public void insertBook(Book book) throws SQLException {
		String sql = "INSERT INTO sample_books (book_no, book_title, book_writer, book_genre, book_publisher, book_price, book_discount_price) ";
		sql += "VALUES (sample_book_seq.NEXTVAL, ?, ?, ?, ?, ?, ?) ";
		
		// DB Access 전처리
		Connection con = ds.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 파라미터값 바인딩
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getWriter());
		pstmt.setString(3, book.getGenre());
		pstmt.setString(4, book.getPublisher());
		pstmt.setInt(5, book.getPrice());
		pstmt.setInt(6, book.getDiscountPrice());
		
		// 쿼리문 실행
		pstmt.executeUpdate();
		
		// DB Access 후처리
		pstmt.close();
		con.close();
	}
	
	public void deleteBook(int bookNo) throws SQLException {
		String sql = "DELETE FROM smaple_books WHERE book_no = ? ";
		
		// DB Access 전처리
		Connection con = ds.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 파라미터 값 바인딩
		pstmt.setInt(1, bookNo);
		
		// 쿼리문 실행
		pstmt.executeUpdate();
		
		// DB Access 후처리
		pstmt.close();
		con.close();
	}
	
	public void updateBook(Book book) throws SQLException {
		String sql = "UPDATE sample_books SET book_price = ?, book_discount_price = ? WHERE book_no = ? ";
		
		// DB Access 전처리
		Connection con = ds.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 파라미터 값 바인딩
		pstmt.setInt(1, book.getPrice());
		pstmt.setInt(2, book.getDiscountPrice());
		
		// 쿼리문 실행
		pstmt.executeUpdate();
		
		// DB Access 후처리
		pstmt.close();
		con.close();
	}
	
	public Book getBookByNo(int bookNo) throws SQLException {
		Book book = null;
		
		String sql = "SELECT book_no, book_title, book_writer, book_genre, book_publisher, book_price, book_discount_price, book_stock, book_registered_date, book_point, book_likes ";
		sql += "FROM sample_books WHERE book_no = ? ";
		
		// DB Access 전처리
		Connection con = ds.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 파라미터 값 바인딩
		pstmt.setInt(1, bookNo);
		
		// 쿼리문 실행
		ResultSet rs = pstmt.executeQuery();
		// 조회결과 처리
		if (rs.next()) {
			book = new Book();
			book.setNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("book_title"));
			book.setWriter(rs.getString("book_writer"));
			book.setGenre(rs.getString("book_genre"));
			book.setPublisher(rs.getString("book_publisher"));
			book.setPrice(rs.getInt("book_price"));
			book.setDiscountPrice(rs.getInt("book_discount_price"));
			book.setStock(rs.getInt("book_stock"));
			book.setRegisteredDate(rs.getDate("book_registered_date"));
			book.setPoint(rs.getDouble("book_point"));
			book.setLikes(rs.getInt("book_likes"));
		}
		
		// DB Access 후처리
		rs.close();
		pstmt.close();
		con.close();
		
		return book;
	}
	
	public List<Book> getAllBooks() throws SQLException {
		List<Book> books = new ArrayList<>();
		
		String sql = "SELECT book_no, book_title, book_writer, book_genre, book_publisher, book_price, book_discount_price, book_stock, book_registered_date, book_point, book_likes ";
		sql += "FROM sample_books ORDER BY book_no ";
		
		// DB Access 전처리
		Connection con = ds.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 쿼리문 실행
		ResultSet rs = pstmt.executeQuery();
		// 조회결과 처리
		while (rs.next()) {
			Book book = new Book();
			book.setNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("book_title"));
			book.setWriter(rs.getString("book_writer"));
			book.setGenre(rs.getString("book_genre"));
			book.setPublisher(rs.getString("book_publisher"));
			book.setPrice(rs.getInt("book_price"));
			book.setDiscountPrice(rs.getInt("book_discount_price"));
			book.setStock(rs.getInt("book_stock"));
			book.setRegisteredDate(rs.getDate("book_registered_date"));
			book.setPoint(rs.getDouble("book_point"));
			book.setLikes(rs.getInt("book_likes"));
			
			books.add(book);
		}
		
		// DB Access 후처리
		rs.close();
		pstmt.close();
		con.close();
		
		return books;
	}
}
