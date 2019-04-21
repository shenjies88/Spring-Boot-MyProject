drop table if exists student;
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
)comment 'mybatis 学生';

insert into student (student_code, name, age, sex) values
  ('1452200111', '张三', '18', '男'),
  ('1452200112', '李四', '19', '男'),
  ('1452200113', '王五', '20', '女'),
  ('1452200114', '韩梅梅', '21', '女');

drop table if exists activity;
create table activity
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
  course                varchar(10) null
  comment '课程',
  constraint activity_activity_student_code_uindex
  unique (activity_student_code)
)comment 'mybatis 学生';

insert into activity (activity_student_code, sports, student_organization, course) values
  ('1452200111', '足球', '摄影协会', '自动控制原理'),
  ('1452200112', '篮球', '科技协会', '高等数学'),
  ('1452200113', '乒乓球', '书法协会', '大学英语'),
  ('1452200114', '羽毛球', '骑行协会', '大学物理');

