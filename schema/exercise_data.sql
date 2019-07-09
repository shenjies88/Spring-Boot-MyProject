USE exercise;
create table if not exists single_index
(
    id       int auto_increment primary key,
    i1_char  varchar(20) null,
    i2_int   int         null,
    i3_date  date        null,
    no_index varchar(20) null,
    index single_index__char (i1_char),
    index single_index__date (i3_date),
    index single_index__int (i2_int)

)
    comment '单索引练习' character set utf8mb4;

INSERT INTO single_index (i1_char, i2_int, i3_date, no_index)
values ('c1', 11, '2019-04-11', 'n1'),
       ('c2', 12, '2019-04-12', 'n2'),
       ('c3', 13, '2019-04-13', 'n3'),
       ('c4', 14, '2019-04-14', 'n4');

create table if not exists union_index
(
    id       int auto_increment
        primary key,
    i1_char  varchar(20) null,
    i2_int   int         null,
    i3_date  date        null,
    no_index varchar(20) null,
    index union_index__char_int_date (i1_char, i2_int, i3_date)
)
    comment '联合索引练习' character set utf8mb4;

INSERT INTO union_index (i1_char, i2_int, i3_date, no_index)
values ('c1', 11, '2019-04-11', 'n1'),
       ('c2', 12, '2019-04-12', 'n2'),
       ('c3', 13, '2019-04-13', 'n3'),
       ('c4', 14, '2019-04-14', 'n4');

