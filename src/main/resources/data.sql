INSERT INTO brand (id, name) VALUES (1, 'zara');
INSERT INTO product (id, name) VALUES (35455, 'shirt');

INSERT INTO price(id, brand_id, start_date, end_date, product_id, priority, price, currency)
VALUES(1, 1, '2020-06-14 00.00.00', '2020-12-31 23.59.59', 35455, 0, 35.5, 'EUR');
INSERT INTO price(id, brand_id, start_date, end_date, product_id, priority, price, currency)
VALUES(2, 1, '2020-06-14 15.00.00', '2020-06-14 18.30.00', 35455, 1, 25.45, 'EUR');
INSERT INTO price(id, brand_id, start_date, end_date, product_id, priority, price, currency)
VALUES(3, 1, '2020-06-15 00.00.00', '2020-06-15 11.00.00', 35455, 1, 30.5, 'EUR');
INSERT INTO price(id, brand_id, start_date, end_date, product_id, priority, price, currency)
VALUES(4, 1, '2020-06-15 16.00.00', '2020-12-31 23.59.59', 35455, 1, 38.95, 'EUR');