--  练习表
create schema if not exists exercise character set utf8mb4 collate utf8mb4_general_ci;

-- Spring Boot表
create schema if not exists spring_boot character set utf8mb4 collate utf8mb4_general_ci;

USE spring_boot;
create table if not exists student
(
    id           int unsigned auto_increment
        comment '主键'
        primary key,
    student_code varchar(20) null
        comment '学号，唯一标识',
    name         varchar(20) null
        comment '姓名',
    age          int(10)     null
        comment '年龄',
    sex          varchar(10) null
        comment '性别',
    constraint myspringboot_student_student_code_uindex
        unique (student_code)
) comment 'mybatis 学生' character set utf8mb4;

insert into student (student_code, name, age, sex)
values ('1452200111', '张三', '18', '男'),
       ('1452200112', '李四', '19', '男'),
       ('1452200113', '王五', '20', '女'),
       ('1452200114', '韩梅梅', '21', '女');

create table if not exists activity
(
    id                    int unsigned auto_increment
        comment '主键'
        primary key,
    activity_student_code varchar(20) null
        comment 'student表的外键',
    sports                varchar(10) null
        comment '运动',
    student_organization  varchar(20) null
        comment '社团',
    course                varchar(20) null
        comment '课程',
    constraint activity_activity_student_code_uindex
        unique (activity_student_code)
) comment 'mybatis 学生' character set utf8mb4;

insert into activity (activity_student_code, sports, student_organization, course)
values ('1452200111', '足球', '摄影协会', '自动控制原理'),
       ('1452200112', '篮球', '科技协会', '高等数学'),
       ('1452200113', '乒乓球', '书法协会', '大学英语'),
       ('1452200114', '羽毛球', '骑行协会', '大学物理');

create table page_helper
(
    id   int unsigned auto_increment
        primary key,
    name varchar(32) default '' null comment '名字',
    age  int         default 1  null comment '年龄'
)
    comment '分页插件实践';

INSERT INTO spring_boot.page_helper (id, name, age)
VALUES (1, '员工1', 1);
INSERT INTO spring_boot.page_helper (id, name, age)
VALUES (2, '员工2', 1);
INSERT INTO spring_boot.page_helper (id, name, age)
VALUES (3, '员工3', 1);
INSERT INTO spring_boot.page_helper (id, name, age)
VALUES (4, '员工4', 1);
INSERT INTO spring_boot.page_helper (id, name, age)
VALUES (5, '员工5', 1);
INSERT INTO spring_boot.page_helper (id, name, age)
VALUES (6, '员工6', 1);
INSERT INTO spring_boot.page_helper (id, name, age)
VALUES (7, '员工7', 1);
INSERT INTO spring_boot.page_helper (id, name, age)
VALUES (8, '员工8', 1);
INSERT INTO spring_boot.page_helper (id, name, age)
VALUES (9, '员工9', 1);
INSERT INTO spring_boot.page_helper (id, name, age)
VALUES (10, '员工10', 1);
INSERT INTO spring_boot.page_helper (id, name, age)
VALUES (11, '员工11', 1);
INSERT INTO spring_boot.page_helper (id, name, age)
VALUES (12, '员工12', 1);
INSERT INTO spring_boot.page_helper (id, name, age)
VALUES (13, '员工13', 1);
INSERT INTO spring_boot.page_helper (id, name, age)
VALUES (14, '员工14', 10);


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








