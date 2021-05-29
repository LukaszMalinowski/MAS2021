INSERT INTO ADDRESS (id, street, house_number, apartment_number, city, zipcode) VALUES (1, 'Street', '10', '20', 'Warsaw', '12-345');

INSERT INTO COMPANY (id, name, address_id, tax_number) VALUES (1, 'Company', 1, '123-456');

INSERT INTO CLIENT (EMAIL, NAME, NUMBER, PHONE_NUMBER, ADDRESS_ID) VALUES ( 'jan@kowalski.pl', 'Jan', 'Kowalski', '500600700', 1 );

INSERT INTO CAR (MARK, MODEL, NET_ENGINE_POWER, PRODUCTION_YEAR, REGISTRATION_NUMBER, VIN_NUMBER, OWNER_ID) VALUES ( 'Fiat', 'Punto', 60, 1996, 'WPR12345', '1234567890', 1 );