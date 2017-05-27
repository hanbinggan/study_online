package cn.edu.upc.study_online.service;

import cn.edu.upc.study_online.controller.vo.LessonVo;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/26.
 */
public interface LessonService {
    Long delete(Long id);

    List<LessonVo> getAllLesson();
}
