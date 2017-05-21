package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.dao.object.LessonDo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/19.
 */
@Repository
public interface LessonMapper {
    LessonDo queryById(Long id);
    Long insert(LessonDo lessonDo);
    Long update(LessonDo lessonDo);
    Long delete(Long id);
    List<LessonDo> selectByCreator(Long creatorId);
}
