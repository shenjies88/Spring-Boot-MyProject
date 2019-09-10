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

# 表jpa自动创建
USE spring_boot;
create table if not exists spring_boot.team
(
    id          bigint auto_increment
        primary key,
    create_time datetime default CURRENT_TIMESTAMP not null,
    update_time datetime default CURRENT_TIMESTAMP not null,
    name        varchar(255)                       null
)
    engine = MyISAM;

create table if not exists spring_boot.player
(
    id          bigint auto_increment
        primary key,
    create_time datetime default CURRENT_TIMESTAMP not null,
    update_time datetime default CURRENT_TIMESTAMP not null,
    name        varchar(255)                       null,
    num         int                                null,
    position    varchar(255)                       null,
    team_id     bigint                             not null
)
    engine = MyISAM;

create index FKdvd6ljes11r44igawmpm1mc5s
    on spring_boot.player (team_id);


insert into team (id, name)
values (1, 'Barcelona');
insert into player (id, team_id, name, num, position)
values (1, 1, 'Lionel Messi', 10, 'Forward');
insert into player (id, team_id, name, num, position)
values (3, 1, 'Pique', 3, 'Defender');
insert into player (id, team_id, name, num, position)
values (2, 1, 'Andreas Inniesta', 8, 'Midfielder');

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






