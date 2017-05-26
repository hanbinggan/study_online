package cn.edu.upc.study_online.service;

import cn.edu.upc.study_online.dao.dao.LessonChapterDao;
import cn.edu.upc.study_online.dao.dao.LessonContentDao;
import cn.edu.upc.study_online.dao.object.LessonChapterDo;
import cn.edu.upc.study_online.dao.object.LessonContentDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/26.
 */
@Component
public class LessonChapterServiceImpl implements LessonChapterService {
    @Autowired
    private LessonContentDao lessonContentDao;
    @Autowired
    private LessonChapterDao lessonChapterDao;
    @Autowired
    private FileService fileService;

    @Override
    public Long delete(Long id) {
        List<LessonContentDo> lessonContentDoList = lessonContentDao.queryByLessonChapter(id);
        for (LessonContentDo lessonContentDo : lessonContentDoList) {
            fileService.delete(lessonContentDo.getFileId());
            lessonContentDao.delete(lessonContentDo.getId());
        }
        return lessonChapterDao.delete(id);
    }

    @Override
    public List<LessonChapterDo> queryByLesson(Long lessonId) {
        return lessonChapterDao.queryByLesson(lessonId);
    }
}
