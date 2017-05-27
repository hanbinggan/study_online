package cn.edu.upc.study_online.service;

import cn.edu.upc.study_online.controller.vo.LessonVo;
import cn.edu.upc.study_online.dao.dao.LessonChapterDao;
import cn.edu.upc.study_online.dao.dao.LessonDao;
import cn.edu.upc.study_online.dao.dao.TeacherDao;
import cn.edu.upc.study_online.dao.object.LessonChapterDo;
import cn.edu.upc.study_online.dao.object.LessonDo;
import cn.edu.upc.study_online.dao.object.TeacherDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by songqiaolin on 2017/5/26.
 */
@Component
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonDao lessonDao;
    @Autowired
    private LessonChapterService lessonChapterService;

    @Autowired
    private LessonConvertor lessonConvertor;


    @Override
    public Long delete(Long id) {
        List<LessonChapterDo> lessonChapterDoList = lessonChapterService.queryByLesson(id);
        for (LessonChapterDo lessonChapterDo : lessonChapterDoList) {
            lessonChapterService.delete(lessonChapterDo.getId());
        }
        return lessonDao.delete(id);
    }

    @Override
    public List<LessonVo> getAllLesson() {
        List<LessonDo> lessonDoList = lessonDao.selectAll();
        return lessonConvertor.lessonListConvert(lessonDoList);
    }
}
