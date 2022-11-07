BEGIN;
DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE IF NOT EXISTS products (id bigserial, title varchar(255), price int, PRIMARY KEY (id));
INSERT INTO products(title,price) VALUES
('Soccer вall',800),
('Jump rope', 600),
('Punching bag',12000),
('Barbell',20000),
('Dumbell',8000);

DROP TABLE IF EXISTS consumers CASCADE;
CREATE TABLE consumers (id bigserial,name VARCHAR(255),cash INT,PRIMARY KEY(id));
INSERT INTO consumers(name,cash) VALUES
 ('Patrik',8000),
 ('Joe', 1600),
 ('Veronica',12700),
 ('Billy',20000),
 ('Dominic',80000);

DROP TABLE IF EXISTS cons_prod CASCADE;
CREATE TABLE IF NOT EXISTS cons_prod(
consumer_id bigint,product_id bigint,
FOREIGN KEY (consumer_id) REFERENCES consumers(id),
FOREIGN KEY (product_id) REFERENCES products(id));
INSERT INTO cons_prod (consumer_id,product_id) VALUES
(1,2),
(1,5),
(2,3),
(3,2);




COMMIT;