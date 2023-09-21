# user table sample data
insert into user (id, password, name, postcode, address, address_detail, email,
                  tel) value ('kks4517', '1234', 'kihong', '03316', '동의빌딩', '8층',
                              'kks4517@naver.com', '010-1234-5678');

insert into user (id, password, name, postcode, address, address_detail, email,
                  tel) value ('signstar', '1234', 'blanc', '03316', '동의빌딩', '8층',
                              'signstar@gmail.com', '010-1234-5678');

insert into user (id, password, name, postcode, address, address_detail, email,
                  tel) value ('blanc', '1234', 'signstar', '03316', '1기동단 16중대', '기동본부',
                              'blanc@gmail.com', '010-1234-5678');
# ---------------------------------------------------------------------------------------

#board table create
create table board
(
    no       int(5) auto_increment primary key,
    title    varchar(300),
    content  varchar(2000),
    name     varchar(30),
    password varchar(100),
    reg_date timestamp default current_timestamp,
    hit      int(5)    default 0
);

#board table sample data
insert into board (title,content,name,password) values ('안뇽안뇽','ㅎㅇㅎㅇ','kihong','1234');