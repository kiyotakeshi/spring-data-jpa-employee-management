INSERT INTO employee
    (id, birthday, first_name, last_name, mail_address, gender)
VALUES (1, '1999-11-29', 'mike', 'popcorn', 'mike.popcorn@mail.com', 'male');
INSERT INTO employee
    (id, birthday, first_name, last_name, mail_address, gender)
VALUES (2, '1989-12-20', 'ichiro', 'yamada', 'ichiro.yamada@mail.com', 'male');
INSERT INTO employee
    (id, birthday, first_name, last_name, mail_address, gender)
VALUES (3, null, 'hanako', 'ishii', null, 'female');

insert
into employee_telephones
    (employee_id, number, type)
values (1, '0120-444-444', 'business');

insert
into employee_telephones
    (employee_id, number, type)
values (1, '0120-555-555', 'business');

insert
into product
(price, category_name, product_name, created_by, created_date, last_modified_by, last_modified_date)
values (20000, 'business', 'display1', 'user', null, 'user', null);

insert
into authentication
    (employee_id, password, id)
values (1, '1qazxsw12', 1);
