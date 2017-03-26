create database study_online;

CREATE TABLE admin(
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  name VARCHAR(50) NOT NULL COMMENT '名字' UNIQUE KEY ,
  password VARCHAR(50) NOT NULL COMMENT '密码'
) ENGINE InnoDB DEFAULT CHARSET utf8mb4 COMMENT '管理员表';