package cn.edu.upc.study_online.dao.object;

/**
 * Created by songqiaolin on 2017/5/27.
 */

import java.util.Date;

/**
 * CREATE TABLE exam (
 * id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
 * lesson_id BIGINT COMMENT '课程 id',
 * name VARCHAR(64) COMMENT '考试名称',
 * create_time DATETIME COMMENT '创建时间',
 * during_time INT COMMENT '考试时间',
 * status TINYINT COMMENT '状态'
 * ) COMMENT '考试';
 */
public class ExamDo {
    private Long id;
    private Long lessonId;
    private String name;
    private Date createTime;
    private Integer duringTime;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getDuringTime() {
        return duringTime;
    }

    public void setDuringTime(Integer duringTime) {
        this.duringTime = duringTime;
    }
}
