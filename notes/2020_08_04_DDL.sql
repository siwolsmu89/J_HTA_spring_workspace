CREATE TABLE spring_categories (
    category_id VARCHAR2(100) PRIMARY KEY,
    category_name VARCHAR2(200) NOT NULL
);

INSERT INTO spring_categories VALUES ('디지털', '디지털제품');
INSERT INTO spring_categories VALUES ('생활가전', '대형/생활가전');
INSERT INTO spring_categories VALUES ('가구', '가구/침구/인테리어');
INSERT INTO spring_categories VALUES ('주방', '조리/식탁/주방용품');
INSERT INTO spring_categories VALUES ('유아동', '유아/아동/완구/애완용품');
INSERT INTO spring_categories VALUES ('의류', '의류/가방/악세사리/잡화');

CREATE TABLE spring_products(
    product_no NUMBER(10) PRIMARY KEY,
    category_id VARCHAR2(100) REFERENCES spring_categories(category_id),
    product_name VARCHAR2(500) NOT NULL,
    product_price NUMBER(10) NOT NULL,
    product_discount_price NUMBER(10) NOT NULL,
    product_stock NUMBER(10) DEFAULT 100,
    product_created_date DATE DEFAULT SYSDATE
);

commit;
