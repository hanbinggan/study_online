package cn.edu.upc.study_online.controller.vo;

import cn.edu.upc.study_online.dao.object.StudentLessonRefDo;

/**
 * Created by songqiaolin on 2017/5/27.
 */
public class StudentLessonRefVo extends StudentLessonRefDo {
    private String studentName;

    public void setStudentLessonRefDo(StudentLessonRefDo studentLessonRefDo){
        this.setId(studentLessonRefDo.getId());
        this.setStudentId(studentLessonRefDo.getStudentId());
        this.setLessonId(studentLessonRefDo.getLessonId());
        this.setStatus(studentLessonRefDo.getStatus());
        this.setCreateTime(studentLessonRefDo.getCreateTime());
        this.setUpdateTime(studentLessonRefDo.getUpdateTime());
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
