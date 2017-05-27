package cn.edu.upc.study_online.controller.vo;

import cn.edu.upc.study_online.dao.object.LessonDo;

/**
 * Created by songqiaolin on 2017/5/26.
 */
public class LessonVo extends LessonDo {

    public void setLessonDo(LessonDo lessonDo) {
        this.setId(lessonDo.getId());
        this.setName(lessonDo.getName());
        this.setCreatorId(lessonDo.getCreatorId());
        this.setCreateTime(lessonDo.getCreateTime());
        this.setUpdateTime(lessonDo.getUpdateTime());
        this.setDescription(lessonDo.getDescription());
        this.setStudyStarScore(this.getStudyStarScore());
    }

    private String teacherName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
