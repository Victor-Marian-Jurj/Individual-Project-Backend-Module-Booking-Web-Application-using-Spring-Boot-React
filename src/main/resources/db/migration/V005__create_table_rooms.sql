CREATE TABLE rooms (
room_id serial PRIMARY KEY,
hotel_id INTEGER NOT NULL,
room_number INTEGER NOT NULL,
room_type VARCHAR(20) NOT NULL,
room_floor INTEGER NOT NULL,
room_price INTEGER NOT NULL,
CONSTRAINT fk_hotel_id
FOREIGN KEY (hotel_id)
REFERENCES hotels (hotel_id)
);