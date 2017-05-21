package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.dao.mapper.LessonChapterMapper;
import cn.edu.upc.study_online.dao.object.LessonChapterDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/20.
 */
@Repository
public class LessonChapterDao {
    @Autowired
    private LessonChapterMapper lessonChapterMapper;

    public Long insert(LessonChapterDo lessonChapterDo) {
        return lessonChapterMapper.insert(lessonChapterDo);
    }

    public Long update(LessonChapterDo lessonChapterDo) {
        return lessonChapterMapper.update(lessonChapterDo);
    }

    public Long delete(Long id) {
        return lessonChapterMapper.delete(id);
    }

    public LessonChapterDo queryById(Long id) {
        return lessonChapterMapper.queryById(id);
    }

    public List<LessonChapterDo> queryByLesson(Long lessonId) {
        return lessonChapterMapper.queryByLesson(lessonId);
    }
}
