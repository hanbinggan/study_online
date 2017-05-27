package cn.edu.upc.study_online.dao.object;

/**
 * Created by songqiaolin on 2017/5/27.
 */

import java.util.Date;

/**
 * CREATE TABLE study_record(
 * id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
 * student_id BIGINT COMMENT '学生 id',
 * lesson_id BIGINT COMMENT '课程 id',
 * type TINYINT COMMENT '产生积分类型',
 * object_id BIGINT COMMENT '对象 id',
 * study_star_record BIGINT COMMENT '学习积分',
 * create_time DATETIME COMMENT '创建时间'
 * ) COMMENT '学习记录';
 */
public class StudyRecordDo {
    private Long id;
    private Long studentId;
    private Long lessonId;
    private Integer type;
    private Long objectId;
    private Long studyStarRecord;
    private Date createTime;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public Long getStudyStarRecord() {
        return studyStarRecord;
    }

    public void setStudyStarRecord(Long studyStarRecord) {
        this.studyStarRecord = studyStarRecord;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
