drop table if exists employee_telephones;
drop table if exists employee;
drop table if exists product;

-- create table if not exists employee
create table employee
(
    id           integer     not null auto_increment,
    birthday     date,
    first_name   varchar(20) not null,
    last_name    varchar(20) not null,
    mail_address varchar(255),
    gender       varchar(10),
    primary key (id)
);

alter table employee
    add constraint unique (mail_address);

create table employee_telephones
(
    employee_id integer not null,
    number      varchar(255),
    type        varchar(255)
);


alter table employee_telephones
    add constraint foreign key (employee_id)
        references employee (id);

create table product
(
    category_name varchar(255) not null,
    product_name  varchar(255) not null,
    price         integer      not null,
    primary key (category_name, product_name)
)
