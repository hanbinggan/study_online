package cn.edu.upc.study_online.dao.object;

/**
 * Created by songqiaolin on 2017/5/19.
 */

import java.util.Date;

/**
 * CREATE TABLE student_lesson_ref (
 * id BIGINT PRIMARY KEY COMMENT 'id',
 * student_id BIGINT COMMENT '学生 id',
 * lesson_id BIGINT COMMENT '课程 id',
 * status TINYINT UNSIGNED COMMENT '状态',
 * create_time DATETIME COMMENT '创建时间',
 * update_time DATETIME COMMENT '更新时间'
 * )COMMENT '学生课程表';
 */
public class StudentLessonRefDo {
    private Long id;
    private Long studentId;
    private Long lessonId;
    private Integer status;
    private Date createTime;
    private Date updateTime;

    public enum STATUS {
        applying(1),
        applied(2),
        finished(3);
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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
