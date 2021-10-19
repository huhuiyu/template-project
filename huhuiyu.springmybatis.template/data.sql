/* 演示需要的表 */
create table tb_springboot_demo_info
(
  iid integer auto_increment primary key not null comment '主键',
  info_key varchar(50) unique comment '信息键值',
  info varchar(2000) comment '信息值',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '演示信息表';

select * from tb_springboot_demo_info;