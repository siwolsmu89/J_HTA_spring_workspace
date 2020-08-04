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

CREATE SEQUENCE spring_product_seq;

CREATE TABLE spring_orders (
    order_no NUMBER(10) PRIMARY KEY,
    order_username VARCHAR2(100) NOT NULL,
    order_tel VARCHAR2(20) NOT NULL,
    order_status VARCHAR2(100) DEFAULT '결제완료',
    order_created_date DATE DEFAULT SYSDATE
);

CREATE SEQUENCE spring_order_seq;

CREATE TABLE spring_order_items (
    item_no NUMBER(10) PRIMARY KEY,
    order_no NUMBER(10) REFERENCES spring_orders (order_no),
    product_no NUMBER(10) REFERENCES spring_products (product_no),
    item_price NUMBER(10) NOT NULL,
    item_amount NUMBER(5) NOT NULL
);

CREATE TABLE spring_order_payments (
    pay_no NUMBER(10) PRIMARY KEY,
    pay_type VARCHAR2(100) NOT NULL,
    pay_account VARCHAR2(100) NOT NULL,
    order_no NUMBER(10) REFERENCES spring_orders (order_no)
);

CREATE TABLE spring_order_delivery (
    delivery_no NUMBER(10) PRIMARY KEY,
    delivery_username VARCHAR2(100) NOT NULL,
    delivery_tel VARCHAR2(30) NOT NULL,
    delivery_address VARCHAR2(500) NOT NULL,
    delivery_status VARCHAR2(50) DEFAULT '물품준비중',
    order_no NUMBER(10) REFERENCES spring_orders (order_no)
);

commit;
