package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.dao.mapper.ExamMapper;
import cn.edu.upc.study_online.dao.object.ExamDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Repository
public class ExamDao {
    @Autowired
    private ExamMapper examMapper;

//    public Long insert(ExamDo examDo) {
//        return examMapper.insert(examDo);
//    }

    public Long update(ExamDo examDo) {
        return examMapper.update(examDo);
    }

    public Long delete(Long id) {
        return examMapper.delete(id);
    }

    public ExamDo queryById(Long id) {
        return examMapper.queryById(id);
    }

    public List<ExamDo> queryByLessonStatus(Long lessonId, Integer status) {
        return examMapper.queryByLessonStatus(lessonId, status);
    }
}
