package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.dao.mapper.LessonContentMapper;
import cn.edu.upc.study_online.dao.object.LessonContentDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/21.
 */
@Repository
public class LessonContentDao {
    @Autowired
    private LessonContentMapper lessonContentMapper;

    public Long insert(LessonContentDo lessonContentDo) {
        return lessonContentMapper.insert(lessonContentDo);
    }

    public Long update(LessonContentDo lessonContentDo) {
        return lessonContentMapper.update(lessonContentDo);
    }

    public Long delete(Long id) {
        return lessonContentMapper.delete(id);
    }

    public LessonContentDo queryById(Long id) {
        return lessonContentMapper.queryById(id);
    }

    public List<LessonContentDo> queryByLessonChapter(Long lessonChapterId) {
        return lessonContentMapper.queryByLessonChapter(lessonChapterId);
    }
}
