CREATE TABLE users(
user_id serial PRIMARY KEY,
username VARCHAR(35) NOT NULL,
password VARCHAR(35) NOT NULL,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(20) NOT NULL,
phone_number VARCHAR(20) NOT NULL UNIQUE,
email_address VARCHAR(50) NOT NULL UNIQUE
);