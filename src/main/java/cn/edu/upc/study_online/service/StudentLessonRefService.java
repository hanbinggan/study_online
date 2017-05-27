package cn.edu.upc.study_online.service;

import cn.edu.upc.study_online.controller.vo.LessonVo;
import cn.edu.upc.study_online.controller.vo.StudentLessonRefVo;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
public interface StudentLessonRefService {
    List<LessonVo> queryLessonByStudentStatus(Long studentId, Integer status);

    List<StudentLessonRefVo> queryByLessonStatus(Long lessonId, Integer status);
}
