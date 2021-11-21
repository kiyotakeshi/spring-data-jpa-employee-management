drop table if exists employee;
drop table if exists employee_talephones;

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

create table employee_telephones
(
    employee_id integer not null,
    number      varchar(255),
    type        varchar(255)
);

alter table employee
    add constraint unique (mail_address);

alter table employee_telephones
    add constraint foreign key (employee_id)
        references employee (id);
