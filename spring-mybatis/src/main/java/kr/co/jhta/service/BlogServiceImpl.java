package kr.co.jhta.service;

import java.util.List;

import org.apache.ibatis.cache.decorators.BlockingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.BlogCommentDao;
import kr.co.jhta.dao.BlogDao;
import kr.co.jhta.dto.BlogDetailDto;
import kr.co.jhta.vo.Blog;
import kr.co.jhta.vo.Comment;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private BlogCommentDao blogCommentDao;
	
	@Override
	public void addNewBlog(Blog blog) {
		blogDao.insertBlog(blog);
	}
	
	@Override
	public void addNewComment(Comment comment) {
		blogCommentDao.insertComment(comment);
	}
	
	@Override
	public List<Blog> getAllBlogs() {
		return blogDao.getBlogs();
	}
	
	@Override
	public BlogDetailDto getBlogDetail(int blogNo) {
		Blog blog = blogDao.getBlogByNo(blogNo);
		List<Comment> comments = blogCommentDao.getCommentsByBlogNo(blogNo);
		return new BlogDetailDto(blog, comments);
	}
	
	@Override
	public void modifyBlog(Blog blog) {
		blogDao.updateBlog(blog);
	}

	@Override
	public void removeBlogByNo(int blogNo) {
		blogCommentDao.deleteCommentsByBlogNo(blogNo);
		blogDao.deleteBlogByNo(blogNo);
	}
	
	@Override
	public void removeComment(int commentNo) {
		blogCommentDao.deleteCommentByNo(commentNo);
	}
}
