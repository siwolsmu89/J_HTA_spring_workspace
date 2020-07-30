DROP TABLE spring_free_boards;

CREATE TABLE spring_free_boards (
    board_no NUMBER(10) PRIMARY KEY,
    board_title VARCHAR2(200) NOT NULL,
    board_writer VARCHAR2(200) NOT NULL,
    board_password VARCHAR2(20) NOT NULL,
    board_content VARCHAR2(2000),
    board_filename VARCHAR2(200),
    board_likes NUMBER(5) DEFAULT 0,
    board_deleted CHAR(1) DEFAULT 'N',
    board_created_date DATE DEFAULT SYSDATE,
    board_updated_date DATE DEFAULT SYSDATE,
    board_deleted_date DATE
);

CREATE SEQUENCE spring_board_seq;