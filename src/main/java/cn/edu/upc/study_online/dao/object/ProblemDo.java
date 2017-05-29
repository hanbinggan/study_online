package cn.edu.upc.study_online.dao.object;

/**
 * Created by songqiaolin on 2017/5/27.
 */

import java.util.Date;

/**
 * CREATE TABLE problem(
 * id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
 * content VARCHAR(512) COMMENT '问题',
 * score TINYINT COMMENT '分数',
 * answer VARCHAR(512) COMMENT '答案',
 * type TINYINT COMMENT '类型',
 * object_id BIGINT COMMENT '类型 id',
 * order_number TINYINT COMMENT '排序',
 * create_time DATETIME DEFAULT now() COMMENT '创建时间'
 * ) COMMENT '题库';
 */
public class ProblemDo {
    private Long id;
    private String content;
    private String answer;
    private Integer score;
    private Integer type;
    private Long objectId;
    private Integer orderNumber;
    private Date createTime;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public enum TYPE {
        exercise(1), exam(2);
        private final int val;

        TYPE(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
