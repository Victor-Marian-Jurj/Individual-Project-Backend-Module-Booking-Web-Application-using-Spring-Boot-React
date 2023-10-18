CREATE TABLE payments (
payment_id serial PRIMARY KEY,
user_id INTEGER NOT NULL,
name_on_card VARCHAR(50) NOT NULL,
card_number BIGINT NOT NULL,
expiration_date Date NOT NULL,
cvc_number INTEGER NOT NULL,
CONSTRAINT fk_payment_users
FOREIGN KEY (user_id)
REFERENCES users (user_id)
);