package cn.edu.upc.study_online.dao.object;

/**
 * Created by songqiaolin on 2017/5/27.
 */

import java.util.Date;

/**
 * CREATE  TABLE exercise(
 * id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
 * chapter_id BIGINT COMMENT '章节 id',
 * name VARCHAR(64) COMMENT '练习名称',
 * create_time DATETIME COMMENT '创建时间'
 * ) COMMENT '练习';
 */
public class ExerciseDo {
    private Long id;
    private Long chapterId;
    private String name;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
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
}
