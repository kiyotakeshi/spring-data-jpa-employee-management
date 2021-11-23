insert into department
    (name, id)
values ('sales', 1);

insert into employee
(id, birthday, first_name, last_name, mail_address, gender, department_id)
values (1, '1999-11-29', 'mike', 'popcorn', 'mike.popcorn@mail.com', 'male', 1);

insert into employee
(id, birthday, first_name, last_name, mail_address, gender, department_id)
values (2, '2009-01-19', 'kendrick', 'west', 'kendrick.west@mail.com', 'male', 1);

insert into employee_telephones
    (employee_id, number, type)
values (1, '0120-444-444', 'business');

insert into employee_telephones
    (employee_id, number, type)
values (1, '0120-555-555', 'business');

insert into product
(price, category_name, product_name, created_by, created_date, last_modified_by, last_modified_date)
values (20000, 'business', 'display1', 'user', '2021-11-22', null, null);

insert into authentication
    (employee_id, password, id)
values (1, '1qazxsw12', 1);

insert into authentication
    (employee_id, password, id)
values (2, '2wsxzaq1', 2);

insert into authorization
    (id, name)
values (1, 'ROLE_USER');

insert into authorization
    (id, name)
values (2, 'ROLE_ADMIN');

INSERT INTO employee_authorization
    (employee_id, authorization_id)
VALUES (1, 1);

INSERT INTO employee_authorization
    (employee_id, authorization_id)
VALUES (1, 2);

INSERT INTO employee_authorization
    (employee_id, authorization_id)
VALUES (2, 2);
