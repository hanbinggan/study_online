package cn.edu.upc.study_online.dao.object;

/**
 * Created by songqiaolin on 2017/5/27.
 */

/**
 *<!--id	bigint(20)-->
 <!--content	varchar(512)-->
 <!--score	tinyint(4)-->
 <!--type	tinyint(4)-->
 <!--object_id	bigint(20)-->
 <!--problem_id	bigint(20)-->
 <!--student_id	tinyint(4)-->
 */
public class AnswerDo {
    private Long id;
    private String content;
    private Integer score;
    private Integer type;
    private Long objectId;
    private Long studentId;
    private Long problemId;

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
