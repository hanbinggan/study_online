package cn.edu.upc.study_online.dao.object;

/**
 * Created by songqiaolin on 2017/5/20.
 */

import java.util.Date;

/**
 *   id BIGINT PRIMARY KEY COMMENT 'id',
 lesson_id BIGINT COMMENT '课程 id',
 name VARCHAR(128) COMMENT '名字',
 description VARCHAR(512) COMMENT '描述',
 order_number BIGINT COMMENT '排序',
 create_time DATETIME COMMENT '创建时间',
 update_time DATETIME COMMENT '更新时间'
 */
public class LessonChapterDo {
    private Long id;
    private Long lessonId;
    private String name;
    private String description;
    private Long orderNumber;
    private Date createTime;
    private Date updateTime;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
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
