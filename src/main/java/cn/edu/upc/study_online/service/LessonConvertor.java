package cn.edu.upc.study_online.service;

import cn.edu.upc.study_online.controller.vo.LessonVo;
import cn.edu.upc.study_online.dao.dao.TeacherDao;
import cn.edu.upc.study_online.dao.object.LessonDo;
import cn.edu.upc.study_online.dao.object.TeacherDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Component
public class LessonConvertor {
    @Autowired
    private TeacherDao teacherDao;

    public List<LessonVo> lessonListConvert(List<LessonDo> lessonDoList) {
        List<TeacherDo> teacherDoList = teacherDao.queryAll();

        Map<Long, String> nameIdMap = new HashMap<>();

        for (TeacherDo teacherDo : teacherDoList) {
            nameIdMap.put(teacherDo.getId(), teacherDo.getName());
        }
        List<LessonVo> lessonVoList = new ArrayList<>();
        for (LessonDo lessonDo : lessonDoList) {
            LessonVo lessonVo = new LessonVo();
            lessonVo.setLessonDo(lessonDo);
            lessonVo.setTeacherName(nameIdMap.get(lessonDo.getCreatorId()));
            lessonVoList.add(lessonVo);
        }
        return lessonVoList;
    }
}
