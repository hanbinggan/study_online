package cn.edu.upc.study_online.service;

import cn.edu.upc.study_online.controller.vo.LessonVo;
import cn.edu.upc.study_online.controller.vo.StudentLessonRefVo;
import cn.edu.upc.study_online.dao.dao.LessonDao;
import cn.edu.upc.study_online.dao.dao.StudentDao;
import cn.edu.upc.study_online.dao.dao.StudentLessonRefDao;
import cn.edu.upc.study_online.dao.object.LessonDo;
import cn.edu.upc.study_online.dao.object.StudentDo;
import cn.edu.upc.study_online.dao.object.StudentLessonRefDo;
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
public class StudentLessonRefServiceImpl implements StudentLessonRefService {
    @Autowired
    private StudentLessonRefDao studentLessonRefDao;

    @Autowired
    private LessonDao lessonDao;

    @Autowired
    private LessonConvertor lessonConvertor;

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<LessonVo> queryLessonByStudentStatus(Long studentId, Integer status) {
        List<StudentLessonRefDo> lessonRefDos = studentLessonRefDao
                .queryByStudentStatus(studentId, status);
        if (lessonRefDos != null && lessonRefDos.size() > 0) {
            List<Long> lessonIds = new ArrayList<>();
            for (StudentLessonRefDo lessonRefDo : lessonRefDos) {
                lessonIds.add(lessonRefDo.getLessonId());
            }
            List<LessonDo> lessonDoList = lessonDao.selectByIds(lessonIds);
            return lessonConvertor.lessonListConvert(lessonDoList);
        }
        return null;
    }

    @Override
    public List<StudentLessonRefVo> queryByLessonStatus(Long lessonId, Integer status) {

        List<StudentLessonRefDo> lessonRefDos = studentLessonRefDao
                .queryByLessonStatus(lessonId, status);
        if (lessonRefDos != null && lessonRefDos.size() > 0) {
            List<StudentLessonRefVo> studentLessonRefVoList = new ArrayList<>();
            List<StudentDo> studentDoList = studentDao.queryAll();
            Map<Long, String> studentIdNameMap = new HashMap<>();
            for (StudentDo studentDo : studentDoList) {
                studentIdNameMap.put(studentDo.getId(), studentDo.getName());
            }
            for (StudentLessonRefDo lessonRefDo : lessonRefDos) {
                StudentLessonRefVo studentLessonRefVo = new StudentLessonRefVo();
                studentLessonRefVo.setStudentLessonRefDo(lessonRefDo);
                studentLessonRefVo.setStudentName(studentIdNameMap.get(studentLessonRefVo.getStudentId()));
                studentLessonRefVoList.add(studentLessonRefVo);
            }
            return studentLessonRefVoList;
        }
        return null;
    }
}
