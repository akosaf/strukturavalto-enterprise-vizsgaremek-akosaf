INSERT INTO category(name) VALUES ('led bulbs');
INSERT INTO category(name) VALUES ('led stripes');
INSERT INTO category(name) VALUES ('led spot');
INSERT INTO category(name) VALUES ('led pendant');

INSERT INTO supplier(name, country, registration_date, discount) VALUES ('Joe', 'China', '2016-06-22', 30);
INSERT INTO supplier(name, country, registration_date, discount) VALUES ('Moe', 'China', '2018-09-30', 30);
INSERT INTO supplier(name, country, registration_date, discount) VALUES ('Moo', 'China', '2021-01-17', 30);
INSERT INTO supplier(name, country, registration_date, discount) VALUES ('Jan', 'Poland', '2021-01-17', 30);

INSERT INTO shipment(shipment_date, supplier_id, weight, currency) VALUES ('2020-01-17', 2, 50, 300);
INSERT INTO shipment(shipment_date, supplier_id, weight, currency) VALUES ('2020-04-20', 1, 35, 302);
INSERT INTO shipment(shipment_date, supplier_id, weight, currency) VALUES ('2021-02-27', 3, 60, 309);

INSERT INTO stock(name, description, expiration, price, quantity, country_of_origin, category_id, shipment_id)
VALUES ('10W-E27-Bulb', '10W led bulb', '2030-01-01', 10, 200, 'China', 1, 2);
INSERT INTO stock(name, description, expiration, price, quantity, country_of_origin, category_id, shipment_id)
VALUES ('10W-GU10-Spot', '6W led spot', '2030-01-01', 8, 100, 'China', 3, 3);
INSERT INTO stock(name, description, expiration, price, quantity, country_of_origin, category_id, shipment_id)
VALUES ('9.6W-Stripe', '9.6W/m led stripe', '2030-01-01', 3, 600, 'China', 2, 3);
