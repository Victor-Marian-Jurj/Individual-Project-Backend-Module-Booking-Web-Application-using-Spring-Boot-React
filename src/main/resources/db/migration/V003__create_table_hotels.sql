CREATE TABLE hotels(
hotel_id serial PRIMARY KEY,
hotel_name VARCHAR(30) NOT NULL,
hotel_location VARCHAR(30) NOT NULL,
rating INTEGER NOT NULL,
room VARCHAR(20) NOT NULL,
price INTEGER NOT NULL,
check_in_interval DATE NOT NULL,
check_out_interval DATE NOT NULL,
breakfast bool NOT NULL,
wifi_connection bool NOT NULL,
private_parking	bool NOT NULL,
minibar bool NOT NULL,
latitude double precision NOT NULL,
longitude double precision NOT NULL
);