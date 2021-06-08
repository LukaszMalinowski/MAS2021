INSERT INTO USER (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD) VALUES ('lukasz.malinowski10@gmail.com', 'Łukasz', 'Malinowski', '$2a$10$fFBNHqZJ27CRlhuehipebex7QXU9xHK9ORQKY8RURU59mLNQc0AJG');

INSERT INTO ADDRESS (id, street, house_number, apartment_number, city, zipcode) VALUES (1, 'Street', '10', '20', 'Warsaw', '12-345');

INSERT INTO COMPANY (id, name, address_id, tax_number) VALUES (1, 'Company', 1, '123-456');

INSERT INTO CLIENT (EMAIL, NAME, NUMBER, PHONE_NUMBER, ADDRESS_ID) VALUES ('jan@kowalski.pl', 'Jan', 'Kowalski', '500600700', 1);

INSERT INTO CAR (MARK, MODEL, NET_ENGINE_POWER, PRODUCTION_YEAR, REGISTRATION_NUMBER, VIN_NUMBER, OWNER_ID) VALUES ('Fiat', 'Punto', 60, 1996, 'WPR12345', '1234567890', 1);

INSERT INTO MECHANIC (HOURLY_RATE, NAME, SURNAME, COMPANY_ID) VALUES (30, 'Tadeusz', 'Nowak', 1);
INSERT INTO MECHANIC (HOURLY_RATE, NAME, SURNAME, COMPANY_ID) VALUES (25, 'Grzegorz', 'Lasocki', 1);

INSERT INTO REPAIR (id, cost, description, receive_date_time, return_date_time) VALUES (1, 160, 'Car was fixed', null, null);

INSERT INTO MECHANIC_REPAIR (hours, notes, mechanic_id, repair_id) VALUES (6, 'Some notes', 1, 1);
INSERT INTO MECHANIC_REPAIR (hours, notes, mechanic_id, repair_id) VALUES (6, 'Some notes', 2, 1);