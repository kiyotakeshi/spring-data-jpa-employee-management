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
    (price, category_name, product_name)
values (20000, 'business', 'display1');
