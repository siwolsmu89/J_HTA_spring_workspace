CREATE TABLE spring_blogs (
    blog_no NUMBER(6) PRIMARY KEY,
    blog_title VARCHAR2(200) NOT NULL,
    blog_writer VARCHAR2(20) REFERENCES spring_users (user_id),
    blog_content VARCHAR2(1000) NOT NULL,
    blog_likes NUMBER(6) DEFAULT 0,
    blog_comment_counts NUMBER(6) DEFAULT 0,
    blog_created_date DATE DEFAULT SYSDATE
);

CREATE TABLE spring_blog_comments (
    comment_no NUMBER(6) PRIMARY KEY,
    comment_writer VARCHAR2(20) REFERENCES spring_users (user_id),
    comment_content VARCHAR2(500) NOT NULL,
    blog_no NUMBER(6) REFERENCES spring_blogs (blog_no),
    comment_created_date DATE DEFAULT SYSDATE
);

CREATE SEQUENCE spring_blog_seq;
CREATE SEQUENCE spring_comment_seq;