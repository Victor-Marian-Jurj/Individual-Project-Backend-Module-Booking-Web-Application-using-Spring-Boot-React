--CREATE TABLE reservations (
--reservation_id serial PRIMARY KEY,
--user_id INTEGER NOT NULL,
--hotel_id INTEGER NOT NULL,
--room_id INTEGER NOT NULL,
--check_in_date DATE NOT NULL,
--check_out_date DATE NOT NULL,
--payment_method VARCHAR(20) NOT NULL,
--total_payment INTEGER NOT NULL,
--CONSTRAINT fk_reservation_users
--FOREIGN KEY (user_id)
--REFERENCES users (user_id),
--CONSTRAINT fk_reservation_hotels
--FOREIGN KEY (hotel_id)
--REFERENCES hotels (hotel_id),
--CONSTRAINT fk_reservation_rooms
--FOREIGN KEY (room_id)
--REFERENCES rooms (room_id)
--);