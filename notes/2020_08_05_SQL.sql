DELETE FROM spring_order_delivery;
DELETE FROM spring_order_payments;
DELETE FROM spring_order_items;
DELETE FROM spring_orders;

ALTER TABLE spring_users ADD user_tel VARCHAR2(20);
ALTER TABLE spring_users ADD user_age NUMBER(3);
ALTER TABLE spring_users ADD user_birth DATE;

COMMIT;