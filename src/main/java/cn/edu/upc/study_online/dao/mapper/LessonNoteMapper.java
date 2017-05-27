package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.dao.object.LessonNoteDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Repository
public interface LessonNoteMapper {
    LessonNoteDo queryById(Long id);

    Long insert(LessonNoteDo lessonNoteDo);

    Long update(LessonNoteDo lessonNoteDo);

    Long delete(Long id);

    List<LessonNoteDo> queryByContent(@Param("contentId") Long contentId);
}
