package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.dao.object.StudentLessonRefDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/20.
 */
@Repository
public interface StudentLessonRefMapper {
    Long insert(StudentLessonRefDo studentLessonRefDo);

    Long update(StudentLessonRefDo studentLessonRefDo);

    Long delete(Long id);

    StudentLessonRefDo queryById(Long id);

    List<StudentLessonRefDo> queryByStudentStatus(@Param("studentId") Long studentId, @Param("status")Integer status);

    List<StudentLessonRefDo> queryByStudent(@Param("studentId") Long studentId);

    List<StudentLessonRefDo> queryByLessonStatus(@Param("lessonId") Long lessonId, @Param("status") Integer status);

    StudentLessonRefDo queryByStudentLesson(@Param("studentId") Long studentId, @Param("lessonId") Long lessonId);
}
