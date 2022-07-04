DROP TABLE IF EXISTS stock;
DROP TABLE IF EXISTS shipment;
DROP TABLE IF EXISTS supplier;
DROP TABLE IF EXISTS category;

CREATE TABLE supplier (
                          id BIGINT GENERATED by default as identity,
                          name VARCHAR(30),
                          country VARCHAR(30),
                          registration_date TIMESTAMP,
                          discount INT,
                          PRIMARY KEY (id)
);
CREATE TABLE shipment (
                          id BIGINT GENERATED by default as identity,
                          shipment_date TIMESTAMP,
                          supplier_id BIGINT,
                          weight INT,
                          currency INT,
                          CONSTRAINT fk_supplier
                              FOREIGN KEY(supplier_id)
                                  REFERENCES supplier(id),
                          PRIMARY KEY (id)
);
CREATE TABLE category (
                          id BIGINT GENERATED by default as identity,
                          name VARCHAR(30),
                          PRIMARY KEY (id)
);
CREATE TABLE stock (
                       id BIGINT GENERATED by default as identity,
                       name VARCHAR(30),
                       description VARCHAR(255),
                       expiration TIMESTAMP,
                       price INT,
                       quantity INT,
                       country_of_origin VARCHAR(30),
                       category_id BIGINT,
                       shipment_id BIGINT,
                       CONSTRAINT fk_category
                           FOREIGN KEY(category_id)
                               REFERENCES category(id),
                       CONSTRAINT fk_shipment
                           FOREIGN KEY(shipment_id)
                               REFERENCES shipment(id),
                       PRIMARY KEY (id)
);
