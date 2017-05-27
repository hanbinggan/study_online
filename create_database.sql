create database study_online;
CREATE TABLE admin
(
  id BIGINT(20) PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL COMMENT '名字',
  password VARCHAR(50) NOT NULL COMMENT '密码'
);
CREATE UNIQUE INDEX name ON admin (name);
CREATE TABLE file
(
  id BIGINT(20) PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
  path VARCHAR(128) COMMENT '文件目录',
  name VARCHAR(64) COMMENT '名字',
  type TINYINT(3) unsigned COMMENT '文件类型',
  create_time DATETIME COMMENT '创建时间',
  update_time DATETIME COMMENT '更新时间'
);
CREATE TABLE lesson
(
  id BIGINT(20) PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
  name VARCHAR(128) COMMENT '名字',
  description VARCHAR(512) COMMENT '描述',
  creator_id BIGINT(20) COMMENT '创建者 id',
  create_time DATETIME COMMENT '创建时间',
  update_time DATETIME COMMENT '更新时间',
  study_star_score BIGINT(20) COMMENT '学习star总分数'
);
CREATE TABLE lesson_chapter
(
  id BIGINT(20) PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
  lesson_id BIGINT(20) COMMENT '课程 id',
  name VARCHAR(128) COMMENT '名字',
  description VARCHAR(512) COMMENT '描述',
  order_number BIGINT(20) COMMENT '排序',
  create_time DATETIME COMMENT '创建时间',
  update_time DATETIME COMMENT '更新时间'
);
CREATE TABLE lesson_content
(
  id BIGINT(20) PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
  lesson_chapter_id BIGINT(20) COMMENT '课程 id',
  name VARCHAR(128) COMMENT '名字',
  file_id BIGINT(20) COMMENT '文件 id',
  create_time DATETIME COMMENT '创建时间',
  update_time DATETIME COMMENT '更新时间',
  order_number BIGINT(20) COMMENT '排序',
  study_star_score BIGINT(20) COMMENT '学习之星分数'
);
CREATE TABLE student
(
  id BIGINT(20) PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL COMMENT '名字',
  password VARCHAR(50) NOT NULL COMMENT '密码',
  email VARCHAR(50) NOT NULL COMMENT '邮箱',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '更新时间'
);
CREATE UNIQUE INDEX name ON student (name);
CREATE TABLE student_lesson_ref
(
  id BIGINT(20) PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
  student_id BIGINT(20) COMMENT '学生 id',
  lesson_id BIGINT(20) COMMENT '课程 id',
  status TINYINT(3) unsigned COMMENT '状态',
  create_time DATETIME COMMENT '创建时间',
  update_time DATETIME COMMENT '更新时间'
);
CREATE TABLE teacher
(
  id BIGINT(20) PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL COMMENT '名字',
  password VARCHAR(50) NOT NULL COMMENT '密码',
  email VARCHAR(50) NOT NULL COMMENT '邮箱',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '更新时间'
);
CREATE UNIQUE INDEX name ON teacher (name);
CREATE TABLE usr_tokenid
(
  id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  usr_id BIGINT(20),
  token_id BIGINT(20),
  create_time DATETIME
);


CREATE TABLE lesson_note(
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  lesson_content_id BIGINT COMMENT '学习内容 id',
  content VARCHAR(512) COMMENT '笔记',
  create_time DATETIME DEFAULT  now() COMMENT '创建时间'
) COMMENT '课程笔记';


CREATE TABLE study_record(
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  student_id BIGINT COMMENT '学生 id',
  lesson_id BIGINT COMMENT '课程 id',
  type TINYINT COMMENT '产生积分类型',
  object_id BIGINT COMMENT '对象 id',
  study_star_record BIGINT COMMENT '学习积分',
  create_time DATETIME COMMENT '创建时间'
) COMMENT '学习记录';


CREATE TABLE problem(
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  content VARCHAR(512) COMMENT '问题',
  score TINYINT COMMENT '分数',
  answer VARCHAR(512) COMMENT '答案',
  type TINYINT COMMENT '类型',
  object_id BIGINT COMMENT '类型 id',
  order_number TINYINT COMMENT '排序',
  create_time DATETIME DEFAULT now() COMMENT '创建时间'
) COMMENT '题库';

CREATE TABLE answer(
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  content VARCHAR(512) COMMENT '回答内容',
  score TINYINT COMMENT '分数',
  type TINYINT COMMENT '类型',
  object_id BIGINT COMMENT '类型 id',
  problem_id BIGINT COMMENT '问题 id',
  student_id TINYINT COMMENT '学生 id'
) COMMENT '回答';

CREATE TABLE exam (
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  lesson_id BIGINT COMMENT '课程 id',
  name VARCHAR(64) COMMENT '考试名称',
  create_time DATETIME COMMENT '创建时间',
  during_time INT COMMENT '考试时间',
  status TINYINT COMMENT '状态'
) COMMENT '考试';

CREATE  TABLE exercise(
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  chapter_id BIGINT COMMENT '章节 id',
  name VARCHAR(64) COMMENT '练习名称',
  create_time DATETIME COMMENT '创建时间'
) COMMENT '练习';

CREATE TABLE study_star_score(
  id BIGINT PRIMARY KEY  AUTO_INCREMENT COMMENT 'id',
  lesson_id BIGINT COMMENT '课程 id',
  type TINYINT COMMENT '学习之星类型',
  precent TINYINT COMMENT '学习之星百分比'
)COMMENT '学习之星配置';
