DROP TABLE IF EXISTS stock;
DROP TABLE IF EXISTS shipment;
DROP TABLE IF EXISTS supplier;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS bin;
DROP TABLE IF EXISTS shelf;
DROP TABLE IF EXISTS rack;
DROP TABLE IF EXISTS aisle;
DROP TABLE IF EXISTS zone;

CREATE TABLE zone (
                      id BIGINT PRIMARY KEY,
                      name VARCHAR(30)
);
CREATE TABLE aisle (
                       id BIGINT PRIMARY KEY,
                       name VARCHAR(30),
                       zone_id BIGINT,
                       CONSTRAINT fk_zone
                           FOREIGN KEY(zone_id)
                               REFERENCES zone(id)
);
CREATE TABLE rack (
                      id BIGINT PRIMARY KEY,
                      name VARCHAR(30),
                      aisle_id BIGINT,
                      CONSTRAINT fk_aisle
                          FOREIGN KEY(aisle_id)
                              REFERENCES aisle(id)
);
CREATE TABLE shelf (
                       id BIGINT PRIMARY KEY,
                       name VARCHAR(30),
                       rack_id BIGINT,
                       CONSTRAINT fk_rack
                           FOREIGN KEY(rack_id)
                               REFERENCES rack(id)
);
CREATE TABLE bin (
                     id BIGINT PRIMARY KEY,
                     name VARCHAR(30),
                     shelf_id BIGINT,
                     CONSTRAINT fk_shelf
                         FOREIGN KEY(shelf_id)
                             REFERENCES shelf(id)
);
CREATE TABLE location (
                          id BIGINT PRIMARY KEY,
                          zone_id BIGINT,
                          aisle_id BIGINT,
                          rack_id BIGINT,
                          shelf_id BIGINT,
                          bin_id BIGINT,
                          CONSTRAINT fk_zone
                              FOREIGN KEY(zone_id)
                                  REFERENCES zone(id),
                          CONSTRAINT fk_aisle
                              FOREIGN KEY(aisle_id)
                                  REFERENCES aisle(id),
                          CONSTRAINT fk_rack
                              FOREIGN KEY(rack_id)
                                  REFERENCES rack(id),
                          CONSTRAINT fk_shelf
                              FOREIGN KEY(shelf_id)
                                  REFERENCES shelf(id),
                          CONSTRAINT fk_bin
                              FOREIGN KEY(bin_id)
                                  REFERENCES bin(id)
);
CREATE TABLE supplier (
                          id BIGINT PRIMARY KEY,
                          name VARCHAR(30),
                          country VARCHAR(30),
                          registration_date TIMESTAMP,
                          discount INT
);
CREATE TABLE shipment (
                          id BIGINT PRIMARY KEY,
                          shipment_date TIMESTAMP,
                          supplier_id BIGINT,
                          weight INT,
                          currency INT,
                          CONSTRAINT fk_supplier
                              FOREIGN KEY(supplier_id)
                                  REFERENCES supplier(id)
);
CREATE TABLE category (
                          id BIGINT PRIMARY KEY,
                          name VARCHAR(30)
);
CREATE TABLE stock (
                       id BIGINT PRIMARY KEY,
                       name VARCHAR(30),
                       description VARCHAR(255),
                       expiration TIMESTAMP,
                       price INT,
                       quantity INT,
                       country_of_origin VARCHAR(30),
                       category_id BIGINT,
                       shipment_id BIGINT,
                       location_id BIGINT,
                       CONSTRAINT fk_category
                           FOREIGN KEY(category_id)
                               REFERENCES category(id),
                       CONSTRAINT fk_shipment
                           FOREIGN KEY(shipment_id)
                               REFERENCES shipment(id),
                       CONSTRAINT fk_location
                           FOREIGN KEY(location_id)
                               REFERENCES location(id)
);