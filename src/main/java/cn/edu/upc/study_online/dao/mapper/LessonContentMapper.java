package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.dao.object.LessonContentDo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/20.
 */
@Repository
public interface LessonContentMapper {
    Long insert(LessonContentDo lessonContentDo);
    Long update(LessonContentDo lessonContentDo);
    Long delete(Long id);
    LessonContentDo queryById(Long id);
    List<LessonContentDo> queryByLessonChapter(Long lessonChapterId);
}
