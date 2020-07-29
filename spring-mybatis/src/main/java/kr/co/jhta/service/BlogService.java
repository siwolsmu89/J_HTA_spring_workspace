package kr.co.jhta.service;

import java.util.List;

import kr.co.jhta.dto.BlogDetailDto;
import kr.co.jhta.vo.Blog;
import kr.co.jhta.vo.Comment;

/**
 * 게시글 등록, 조회, 상세조회, 수정, 삭제 기능 제공
 * @author JHTA
 *
 */
public interface BlogService {

	void addNewBlog(Blog blog);
	void addNewComment(Comment comment);
	List<Blog> getAllBlogs();
	BlogDetailDto getBlogDetail(int blogNo);
	void modifyBlog(Blog blog);
	void removeBlogByNo(int blogNo);
	void removeComment(int commentNo);
}
