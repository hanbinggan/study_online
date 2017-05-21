package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.dao.object.LessonChapterDo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/20.
 */
@Repository
public interface LessonChapterMapper {
    Long insert(LessonChapterDo lessonChapterDo);
    Long update(LessonChapterDo lessonChapterDo);
    Long delete(Long id);
    LessonChapterDo queryById(Long id);
    List<LessonChapterDo> queryByLesson(Long lessonId);
}
