INSERT INTO customers(name, last_Name, phone_Number) VALUES ('Vlad', 'Burylo', '0961457898');
INSERT INTO customers(name, last_Name, phone_Number) VALUES ('Vital', 'Volovnik', '0961457745');

INSERT INTO transporters(phone_Number, name) VALUES ('0971578945', 'SuperCompany');
INSERT INTO transporters(phone_Number, name) VALUES ('0971571545', 'CompanySuper');

INSERT INTO authorizations(email, password, role, customer_id) VALUES ('vladburilo@gmail.com', '$2a$10$1yRYL8okTK14GjvRrNCCbu1WNmPwUXCL9LCyOX7YtLKNwPxtrCpTm', 'USER', 1);
INSERT INTO authorizations(email, password, role, customer_id) VALUES ('vital@gmail.com', '$2a$10$1yRYL8okTK14GjvRrNCCbu1WNmPwUXCL9LCyOX7YtLKNwPxtrCpTm', 'USER', 2);


INSERT INTO authorizations(email, password, role, transporter_id) VALUES ('company@gmail.com', '$2a$10$1yRYL8okTK14GjvRrNCCbu1WNmPwUXCL9LCyOX7YtLKNwPxtrCpTm', 'TRANSPORTER', 1);
INSERT INTO authorizations(email, password, role, transporter_id) VALUES ('companyProdation@gmail.com', '$2a$10$1yRYL8okTK14GjvRrNCCbu1WNmPwUXCL9LCyOX7YtLKNwPxtrCpTm', 'TRANSPORTER', 2);

INSERT INTO deliveries(address_country, address_city, address_street, destination_country ,destination_city, destination_street, state, description, creation_date, departure_date, arrival_date, customer_id) VALUES ('Ukraine', 'Ternopil', 'shevchenka 15', 'Ukraine', 'Lviv', 'shevchenka 54', 'CANCELED', 'Information', '2018-05-01T06:47:35', '2022-05-05T06:12:03', '2022-09-01T02:47:17',1);
INSERT INTO deliveries(address_country, address_city, address_street, destination_country ,destination_city, destination_street, state, description, creation_date, departure_date, arrival_date, customer_id) VALUES ('Ukraine', 'Ternopil', 'shevchenka 15', 'Ukraine', 'Lviv', 'shevchenka 54', 'CANCELED', 'Information', '2018-05-01T06:47:35', '2022-05-05T09:15:15', '2022-09-01T07:10:22', 2);


INSERT INTO cargoes(item_name, weight, unit, quantity, delivery_id) VALUES ('bike', 2, 'KILOGRAM', 2, 1);
INSERT INTO cargoes(item_name, weight, unit, quantity, delivery_id) VALUES ('computer', 2, 'KILOGRAM', 2, 2);

INSERT INTO offers(transportation_info, price, state,  transporter_id, delivery_id) values ('Information', 500, 'STATEMENT_CREATED', 1, 1);
INSERT INTO offers(transportation_info, price, state, transporter_id, delivery_id) values ('Information', 900, 'STATEMENT_CREATED', 2, 2);
