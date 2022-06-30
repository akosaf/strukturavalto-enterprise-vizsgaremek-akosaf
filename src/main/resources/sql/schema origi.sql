DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS shipment;
DROP TABLE IF EXISTS supplier;
DROP TABLE IF EXISTS wh_location;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS wh_shelf;
DROP TABLE IF EXISTS wh_column;
DROP TABLE IF EXISTS wh_row;
DROP TABLE IF EXISTS wh_room;
DROP TABLE IF EXISTS wh_floor;
DROP TABLE IF EXISTS wh_building;

CREATE TABLE wh_building (
	id BIGINT PRIMARY KEY,
	name VARCHAR(30)
);
CREATE TABLE wh_floor (
	id BIGINT PRIMARY KEY,
	name VARCHAR(30),
	building_id BIGINT,
	CONSTRAINT fk_building
		FOREIGN KEY(building_id)
		REFERENCES wh_building(id)
);
CREATE TABLE wh_room (
	id BIGINT PRIMARY KEY,
	name VARCHAR(30),
	floor_id BIGINT,
	CONSTRAINT fk_floor
		FOREIGN KEY(floor_id)
		REFERENCES wh_floor(id)
);
CREATE TABLE wh_row (
	id BIGINT PRIMARY KEY,
	name VARCHAR(30),
	room_id BIGINT,
	CONSTRAINT fk_room
		FOREIGN KEY(room_id)
		REFERENCES wh_room(id)
);
CREATE TABLE wh_column (
	id BIGINT PRIMARY KEY,
	name VARCHAR(30),
	row_id BIGINT,
	CONSTRAINT fk_row
		FOREIGN KEY(row_id)
		REFERENCES wh_row(id)
);
CREATE TABLE wh_shelf (
	id BIGINT PRIMARY KEY,
	name VARCHAR(30),
	column_id BIGINT,
	CONSTRAINT fk_column
		FOREIGN KEY(column_id)
		REFERENCES wh_column(id)
);
CREATE TABLE wh_location (
	id BIGINT PRIMARY KEY,
	item_id BIGINT,
	building_id BIGINT,
	floor_id BIGINT,
	room_id BIGINT,
	row_id BIGINT,
	column_id BIGINT,
	shelf_id BIGINT,
	CONSTRAINT fk_building
		FOREIGN KEY(building_id)
		REFERENCES wh_building(id),
	CONSTRAINT fk_floor
		FOREIGN KEY(floor_id)
		REFERENCES wh_floor(id),
	CONSTRAINT fk_room
		FOREIGN KEY(room_id)
		REFERENCES wh_room(id),
	CONSTRAINT fk_row
		FOREIGN KEY(row_id)
		REFERENCES wh_row(id),
	CONSTRAINT fk_column
		FOREIGN KEY(column_id)
		REFERENCES wh_column(id),
	CONSTRAINT fk_shelf
		FOREIGN KEY(shelf_id)
		REFERENCES wh_shelf(id)
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
CREATE TABLE item (
	id BIGINT PRIMARY KEY,
	name VARCHAR(30),
	description VARCHAR(255),
	expiration TIMESTAMP,
	price INT,
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
		REFERENCES wh_location(id)
);