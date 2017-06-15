package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.dao.mapper.StudentLessonRefMapper;
import cn.edu.upc.study_online.dao.object.StudentLessonRefDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/20.
 */
@Repository
public class StudentLessonRefDao {
    @Autowired
    private StudentLessonRefMapper studentLessonRefMapper;

    public Long insert(StudentLessonRefDo studentLessonRefDo) {
        return studentLessonRefMapper.insert(studentLessonRefDo);
    }

    public Long update(StudentLessonRefDo studentLessonRefDo) {
        return studentLessonRefMapper.update(studentLessonRefDo);
    }

    public Long delete(Long id) {
        return studentLessonRefMapper.delete(id);
    }

    public StudentLessonRefDo queryById(Long id) {
        return studentLessonRefMapper.queryById(id);
    }

    public List<StudentLessonRefDo> queryByStudentStatus(Long studentId, Integer status) {
        return studentLessonRefMapper.queryByStudentStatus(studentId, status);
    }

    public List<StudentLessonRefDo> queryByLessonStatus(Long lessonId, Integer status) {
        return studentLessonRefMapper.queryByLessonStatus(lessonId, status);
    }

    public StudentLessonRefDo queryByStudentLesson(Long studentId, Long lessonId) {
        return studentLessonRefMapper.queryByStudentLesson(studentId, lessonId);
    }

    public List<StudentLessonRefDo> queryByStudent(Long studentId){
        return studentLessonRefMapper.queryByStudent(studentId);
    }

}
