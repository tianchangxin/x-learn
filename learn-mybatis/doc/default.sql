-- 创建一个用户管理数据库
create database userManager;

-- 使用 userManager 数据库 创建一个用户表,并添加描述
use userManager;

-- 创建用户表
create table user(
                     id int primary key auto_increment,
                     username varchar(255) not null comment '用户名',
                     password varchar(255) not null comment '密码',
                     email varchar(255)  null comment '邮箱',
                     phone varchar(20)  null comment '电话',
                     address varchar(255)  null comment '地址',
                     sex tinyint null comment '性别 0-女,1-男',
                     real_name varchar(255) null comment '真实姓名',
                     role varchar(255) not null comment '角色(1-管理员,2-用户)',
                     create_time datetime default current_timestamp comment '创建时间',
                     update_time datetime default current_timestamp on update current_timestamp comment '更新时间'
);

-- 添加一个超级管理员
insert into user(username,password,role) values('admin','123456','1');
-- 添加一个普通用户
insert into user(username,password,role) values('user','123456','2');
-- 添加一个普通用户
insert into user(username,password,role) values('user2','123456','2');
-- 添加一个普通用户
insert into user(username,password,role) values('user3','123456','2');

