package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.dao.object.TeacherDo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/4/8.
 */
@Repository
public interface TeacherMapper {
    Long insert(TeacherDo teacherDo);
    TeacherDo queryByName(String name);
    TeacherDo queryById(Long id);
    Long update(TeacherDo teacherDo);
    Long delete(Long id);
    List<TeacherDo> queryAll();
}
