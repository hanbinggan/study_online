package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.dao.object.ExamDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Repository
public interface ExamMapper {
    Long insert(ExamDo examDo);
    Long update(ExamDo examDo);
    Long delete(Long id);
    ExamDo queryById(Long id);
    List<ExamDo> queryByLessonStatus(@Param("LessonId") Long lessonId, @Param("status")Integer status);
    List<ExamDo> queryByLesson(@Param("lessonId") Long lessonId);
}
