CREATE TABLE spring_users (
    user_id VARCHAR2(20) PRIMARY KEY,
    user_name VARCHAR2(100) NOT NULL,
    user_password VARCHAR2(20) NOT NULL,
    user_email VARCHAR2(200) NOT NULL,
    user_created_date DATE DEFAULT SYSDATE
);
