DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial,  price int, title varchar(255),PRIMARY KEY (id));
INSERT INTO products(title,price) VALUES ('Soccer вall',800),  ('Jump rope', 600), ('Punching bag',12000), ('Barbell',20000),('Dumbell',8000);