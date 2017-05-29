package cn.edu.upc.study_online.dao.object;

/**
 * Created by songqiaolin on 2017/5/27.
 */

import java.util.Date;

/**
 * CREATE TABLE `exam` (
 * `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
 * `lesson_id` bigint(20) DEFAULT NULL COMMENT '课程 id',
 * `name` varchar(64) DEFAULT NULL COMMENT '考试名称',
 * `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 * start_time DATETIME COMMENT '考试开始时间',
 * `end_time` DATETIME DEFAULT NULL COMMENT '考试结束时间',
 * `status` tinyint(4) DEFAULT NULL COMMENT '状态',
 * PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考试'
 */
public class ExamDo {
    private Long id;
    private Long lessonId;
    private String name;
    private Date createTime;
    private Date startTime;
    private Date endTime;
    private Integer status;


    public enum STATUS {
        create(1),
        finished(2);
        private final int value;

        STATUS(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
