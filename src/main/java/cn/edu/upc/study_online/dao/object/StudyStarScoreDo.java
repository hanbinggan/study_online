package cn.edu.upc.study_online.dao.object;

/**
 * Created by songqiaolin on 2017/5/27.
 */
/**
 * CREATE TABLE study_star_score(
 * id BIGINT PRIMARY KEY  AUTO_INCREMENT COMMENT 'id',
 * lesson_id BIGINT COMMENT '课程 id',
 * type TINYINT COMMENT '学习之星类型',
 * precent TINYINT COMMENT '学习之星百分比'
 * )COMMENT '学习之星配置';
 */
public class StudyStarScoreDo {
    private Long id;
    private Long lessonId;
    private Integer type;
    private Integer precent;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPrecent() {
        return precent;
    }

    public void setPrecent(Integer precent) {
        this.precent = precent;
    }
}
