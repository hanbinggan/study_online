package cn.edu.upc.study_online.service;

import cn.edu.upc.study_online.dao.object.LessonChapterDo;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/26.
 */
public interface LessonChapterService {
    Long delete(Long id);

    List<LessonChapterDo> queryByLesson(Long lessonId);
}
