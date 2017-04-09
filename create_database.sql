create database study_online;

CREATE TABLE admin(
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  name VARCHAR(50) NOT NULL COMMENT '名字' UNIQUE KEY ,
  password VARCHAR(50) NOT NULL COMMENT '密码'
) ENGINE InnoDB DEFAULT CHARSET utf8mb4 COMMENT '管理员表';


CREATE TABLE teacher(
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  name VARCHAR(50) NOT NULL COMMENT '名字' UNIQUE KEY ,
  password VARCHAR(50) NOT NULL COMMENT '密码',
  email VARCHAR(50) NOT NULL COMMENT '邮箱',
  create_time DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT now() COMMENT '更新时间'
) ENGINE InnoDB DEFAULT CHARSET utf8mb4 COMMENT '教师表';

CREATE TABLE student (
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  name VARCHAR(50) NOT NULL COMMENT '名字' UNIQUE KEY ,
  password VARCHAR(50) NOT NULL COMMENT '密码',
  email VARCHAR(50) NOT NULL COMMENT '邮箱',
  create_time DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT now() COMMENT '更新时间'
)ENGINE InnoDB DEFAULT CHARSET utf8mb4 COMMENT '学生表';
