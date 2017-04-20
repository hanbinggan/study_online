package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.dao.mapper.TeacherMapper;
import cn.edu.upc.study_online.dao.object.TeacherDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/4/8.
 */
@Repository
public class TeacherDao {
    @Autowired
    private TeacherMapper teacherMapper;

    public Long insert(TeacherDo teacherDo){
        return teacherMapper.insert(teacherDo);
    }

    public TeacherDo queryByName(String name){
        return teacherMapper.queryByName(name);
    }

    public TeacherDo queryById(Long id){
        return teacherMapper.queryById(id);
    }

    public Long update(TeacherDo teacherDo){
        return teacherMapper.update(teacherDo);
    }

    public Long delete(Long id){
        return teacherMapper.delete(id);
    }

    public List<TeacherDo> queryAll(){
        return teacherMapper.queryAll();
    }
}
