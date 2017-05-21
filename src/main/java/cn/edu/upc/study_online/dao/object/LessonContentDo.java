package cn.edu.upc.study_online.dao.object;

/**
 * Created by songqiaolin on 2017/5/20.
 */

import java.util.Date;

public class LessonContentDo {
    private Long id;
    private Long lessonChapterId;
    private String name;
    private Long fileId;
    private Date createTime;
    private Date updateTime;
    private Long orderNumber;
    private Long studyStarScore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLessonChapterId() {
        return lessonChapterId;
    }

    public void setLessonChapterId(Long lessonChapterId) {
        this.lessonChapterId = lessonChapterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
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

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getStudyStarScore() {
        return studyStarScore;
    }

    public void setStudyStarScore(Long studyStarScore) {
        this.studyStarScore = studyStarScore;
    }
}
