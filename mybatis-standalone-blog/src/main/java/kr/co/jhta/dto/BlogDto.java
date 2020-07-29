package kr.co.jhta.dto;

import java.util.Date;

public class BlogDto {

	private String userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private Date userCreatedDate;
	private int blogNo;
	private String blogTitle;
	private String blogWriter;
	private String blogContent;
	private int blogLikes;
	private int blogCommentCounts;
	private Date blogCreateDate;
	
	public BlogDto() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserCreatedDate() {
		return userCreatedDate;
	}

	public void setUserCreatedDate(Date userCreatedDate) {
		this.userCreatedDate = userCreatedDate;
	}

	public int getBlogNo() {
		return blogNo;
	}

	public void setBlogNo(int blogNo) {
		this.blogNo = blogNo;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogWriter() {
		return blogWriter;
	}

	public void setBlogWriter(String blogWriter) {
		this.blogWriter = blogWriter;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public int getBlogLikes() {
		return blogLikes;
	}

	public void setBlogLikes(int blogLikes) {
		this.blogLikes = blogLikes;
	}

	public int getBlogCommentCounts() {
		return blogCommentCounts;
	}

	public void setBlogCommentCounts(int blogCommentCounts) {
		this.blogCommentCounts = blogCommentCounts;
	}

	public Date getBlogCreateDate() {
		return blogCreateDate;
	}

	public void setBlogCreateDate(Date blogCreateDate) {
		this.blogCreateDate = blogCreateDate;
	}
	
	
}
