CREATE TABLE spring_user_roles (
    user_id VARCHAR2(20) REFERENCES spring_users (user_id),
    has_role VARCHAR2(20) CHECK (has_role IN ('user', 'admin'))
);

CREATE TABLE spring_url_roles (
    reg_url VARCHAR2(100) NOT NULL,
    reg_role VARCHAR2(20) CHECK (reg_role IN ('user', 'admin'))
);

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/board/add.do', 'user');

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/board/add.do', 'admin');

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/board/delete.do', 'user');

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/board/delete.do', 'admin');

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/order/step1.do', 'user');

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/order/step2.do', 'user');

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/order/step3.do', 'user');

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/order/step4.do', 'user');

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/order/cancel.do', 'user');

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/order/completed.do', 'user');

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/product/add.do', 'admin');

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/signout.do', NULL);

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/board/list.do', null);

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/board/likes.do', null);

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/board/detail.do', null);

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/board/download.do', null);

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/home.do', null);

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/product/list.do', null);

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/signin.do', null);

INSERT INTO spring_url_roles
(reg_url, reg_role)
VALUES
('/signup.do', null);

INSERT INTO spring_users 
    (user_id, user_name, user_password, user_email, user_tel, user_age, user_birth)
VALUES 
    ('tester', '테스터', 'zxcv1234', 'tester@t.t', '123-1234', '25', sysdate-1);

INSERT INTO spring_users 
    (user_id, user_name, user_password, user_email, user_tel, user_age, user_birth)
VALUES 
    ('operator', '운영자', 'zxcv1234', 'operator@t.t', '123-1234', '25', sysdate-1);

INSERT INTO spring_user_roles
    (user_id, has_role)
VALUES
    ('tester', 'user');

INSERT INTO spring_user_roles
    (user_id, has_role)
VALUES
    ('operator', 'admin');

INSERT INTO spring_user_roles
    (user_id, has_role)
VALUES
    ('operator', 'user');

commit;