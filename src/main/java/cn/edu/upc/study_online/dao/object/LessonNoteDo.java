package cn.edu.upc.study_online.dao.object;

/**
 * Created by songqiaolin on 2017/5/27.
 */

import java.util.Date;

/**
 * CREATE TABLE lesson_note(
 id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
 lesson_content_id BIGINT COMMENT '学习内容 id',
 content VARCHAR(512) COMMENT '笔记',
 create_time DATETIME DEFAULT  now() COMMENT '创建时间'
 ) COMMENT '课程笔记';
 */
public class LessonNoteDo {
    private Long id;
    private Long lessonContentId;
    private String content;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLessonContentId() {
        return lessonContentId;
    }

    public void setLessonContentId(Long lessonContentId) {
        this.lessonContentId = lessonContentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
