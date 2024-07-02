CREATE TABLE reservations (
reservation_id serial PRIMARY KEY,
hotel_id INTEGER NOT NULL,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(20) NOT NULL,
phone_number VARCHAR(20) NOT NULL UNIQUE,
email_address VARCHAR(50) NOT NULL UNIQUE,
check_in_date DATE NOT NULL,
check_out_date DATE NOT NULL,
room_type VARCHAR(20) NOT NULL,
room_price INTEGER NOT NULL,
payment_method VARCHAR(20) NOT NULL,
total_payment INTEGER NOT NULL,
CONSTRAINT fk_reservation_hotels
FOREIGN KEY (hotel_id)
REFERENCES hotels (hotel_id)
);