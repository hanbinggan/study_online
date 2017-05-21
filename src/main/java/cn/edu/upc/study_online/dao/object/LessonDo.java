package cn.edu.upc.study_online.dao.object;

/**
 * Created by songqiaolin on 2017/5/19.
 */

import java.util.Date;

/**
 *
 CREATE TABLE lesson (
 id               BIGINT PRIMARY KEY
 COMMENT 'id',
 name             VARCHAR(128) COMMENT '名字',
 description      VARCHAR(512) COMMENT '描述',
 creator_id       BIGINT COMMENT '创建者 id',
 create_time      DATETIME COMMENT '创建时间',
 update_time      DATETIME COMMENT '更新时间',
 study_star_score BIGINT COMMENT '学习star总分数'
 )
 */
public class LessonDo {
    private Long id;
    private String name;
    private String description;
    private Long creatorId;
    private Date createTime;
    private Date updateTime;
    private Long studyStarScore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
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

    public Long getStudyStarScore() {
        return studyStarScore;
    }

    public void setStudyStarScore(Long studyStarScore) {
        this.studyStarScore = studyStarScore;
    }
}
