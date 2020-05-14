create table student
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
) comment 'mybatis 学生';

insert into student (student_code, name, age, sex)
values ('1452200111', '张三', '18', '男'),
       ('1452200112', '李四', '19', '男'),
       ('1452200113', '王五', '20', '女'),
       ('1452200114', '韩梅梅', '21', '女');

create table  activity
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
) comment 'mybatis 学生';

insert into activity (activity_student_code, sports, student_organization, course)
values ('1452200111', '足球', '摄影协会', '自动控制原理'),
       ('1452200112', '篮球', '科技协会', '高等数学'),
       ('1452200113', '乒乓球', '书法协会', '大学英语'),
       ('1452200114', '羽毛球', '骑行协会', '大学物理');

create table  page_helper
(
    id   int unsigned auto_increment
        primary key,
    name varchar(32) default '' null comment '名字',
    age  int         default 1  null comment '年龄'
)
    comment '分页插件实践';

INSERT INTO page_helper (id, name, age)
VALUES (1, '员工1', 1);
INSERT INTO page_helper (id, name, age)
VALUES (2, '员工2', 1);
INSERT INTO page_helper (id, name, age)
VALUES (3, '员工3', 1);
INSERT INTO page_helper (id, name, age)
VALUES (4, '员工4', 1);
INSERT INTO page_helper (id, name, age)
VALUES (5, '员工5', 1);
INSERT INTO page_helper (id, name, age)
VALUES (6, '员工6', 1);
INSERT INTO page_helper (id, name, age)
VALUES (7, '员工7', 1);
INSERT INTO page_helper (id, name, age)
VALUES (8, '员工8', 1);
INSERT INTO page_helper (id, name, age)
VALUES (9, '员工9', 1);
INSERT INTO page_helper (id, name, age)
VALUES (10, '员工10', 1);
INSERT INTO page_helper (id, name, age)
VALUES (11, '员工11', 1);
INSERT INTO page_helper (id, name, age)
VALUES (12, '员工12', 1);
INSERT INTO page_helper (id, name, age)
VALUES (13, '员工13', 1);
INSERT INTO page_helper (id, name, age)
VALUES (14, '员工14', 10);

create table goods
(
    id   int unsigned auto_increment comment '主键' primary key,
    name varchar(20)  not null comment '商品名',
    num  int unsigned not null comment '商品数量'
) comment '商品秒杀表';

insert into goods (name, num)
values ('牙刷', 100);