package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.dao.object.StudentLessonRefDo;
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
    List<StudentLessonRefDo> queryByStudentStatus(Long studentId, Integer status);
    List<StudentLessonRefDo> queryByLessonStatus(Long lessonId, Integer status);
}
