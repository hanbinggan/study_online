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

CREATE TABLE lesson (
  id               BIGINT PRIMARY KEY AUTO_INCREMENT
  COMMENT 'id',
  name             VARCHAR(128) COMMENT '名字',
  description      VARCHAR(512) COMMENT '描述',
  creator_id       BIGINT COMMENT '创建者 id',
  create_time      DATETIME COMMENT '创建时间',
  update_time      DATETIME COMMENT '更新时间',
  study_star_score BIGINT COMMENT '学习star总分数'
)
  COMMENT '课程表';

CREATE TABLE student_lesson_ref (
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  student_id BIGINT COMMENT '学生 id',
  lesson_id BIGINT COMMENT '课程 id',
  status TINYINT UNSIGNED COMMENT '状态',
  create_time DATETIME COMMENT '创建时间',
  update_time DATETIME COMMENT '更新时间'
)COMMENT '学生课程表';

CREATE TABLE lesson_chapter (
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  lesson_id BIGINT COMMENT '课程 id',
  name VARCHAR(128) COMMENT '名字',
  description VARCHAR(512) COMMENT '描述',
  order_number BIGINT COMMENT '排序',
  create_time DATETIME COMMENT '创建时间',
  update_time DATETIME COMMENT '更新时间'
) COMMENT '课程章节表';


CREATE TABLE lesson_content(
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  lesson_chapter_id BIGINT COMMENT '课程 id',
  name VARCHAR(128) COMMENT '名字',
  file_id BIGINT COMMENT '文件 id',
  create_time DATETIME COMMENT '创建时间',
  update_time DATETIME COMMENT '更新时间',
  order_number BIGINT COMMENT '排序',
  study_star_score BIGINT COMMENT '学习之星分数'
) COMMENT '课程内容表';


CREATE TABLE file(
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  path VARCHAR(128) COMMENT '文件目录',
  name VARCHAR(64) COMMENT '名字',
  type TINYINT UNSIGNED COMMENT '文件类型',
  create_time DATETIME COMMENT '创建时间',
  update_time DATETIME COMMENT '更新时间'
) COMMENT '文件';