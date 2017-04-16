package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.dao.object.StudentDo;
import org.springframework.stereotype.Repository;

/**
 * Created by songqiaolin on 2017/4/8.
 */
@Repository
public interface StudentMapper {
    Long insert(StudentDo studentDo);
    StudentDo queryByName(String name);
    StudentDo queryById(Long id);
    Long update(StudentDo studentDo);
    Long delete(Long id);
}
