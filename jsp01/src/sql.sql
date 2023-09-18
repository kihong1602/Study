create table user
(
    no             int(5) auto_increment primary key,
    id             varchar(30) not null unique,
    password       varchar(50) not null,
    postcode       int(8)      not null,
    address        varchar(100),
    address_detail varchar(100),
    reg_date       timestamp default current_timestamp on update current_timestamp
);