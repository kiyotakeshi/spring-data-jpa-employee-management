create table employee
(
    id           integer     not null auto_increment,
    birthday     date,
    first_name   varchar(20) not null,
    last_name    varchar(20) not null,
    mail_address varchar(255),
    gender          varchar(10),
    primary key (id)
);

alter table employee
    add constraint UK_juipuvrjn0ygo4oe6qtu9jyuj unique (mail_address);
