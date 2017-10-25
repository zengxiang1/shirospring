drop table if exists sys_role;
create table sys_role(
    id  int primary key auto_increment comment'主键',
    role_name varchar(255) comment'角色名称',
    resource  varchar(255) comment'拥有资源',
    parent_id int comment'父角色id',
    gmt_create  datetime default current_timestamp comment'创建时间',
    gmt_update datetime default current_timestamp on update current_timestamp comment'更新时间'
)comment'角色表';


drop table if exists sys_user;
create table sys_user(
    id  int primary key auto_increment comment'主键',
    real_name varchar(255) comment'姓名',
    phone_number varchar(20) comment '手机号码',
    address varchar(255) comment '地址',
    age int(3) comment'年龄',
    sex varchar(1) comment '性别',
    register_time datetime comment '注册时间',
    gmt_create  datetime default current_timestamp comment'创建时间',
    gmt_update datetime default current_timestamp on update current_timestamp comment'更新时间'
)comment '用户表';




drop table if exists local_auth;
create table local_auth(
    id  int primary key auto_increment comment'主键',
    user_id int not null comment '用户id',
    account_name  varchar(255) UNIQUE not null comment '用户名',
    account_pwd varchar(255) comment '密码',
    account_status int(2) DEFAULT 0 comment '用户状态',
    sys_role text comment '关联角色id',
    gmt_create  datetime default current_timestamp comment'创建时间',
    gmt_update datetime default current_timestamp on update current_timestamp comment'更新时间'
)comment '认证信息表';


drop table if exists sys_resource;
create table sys_resource(
    id  int primary key auto_increment comment'主键',
    resource_type enum('button','menu') comment '资源类型',
    resource_path varchar(255) comment '资源路径',
    resource_permission varchar(255)  comment'资源权限',
    gmt_create  datetime default current_timestamp comment'创建时间',
    gmt_update datetime default current_timestamp on update current_timestamp comment'更新时间'
)







