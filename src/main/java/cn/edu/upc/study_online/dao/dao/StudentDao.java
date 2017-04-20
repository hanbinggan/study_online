package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.dao.mapper.StudentMapper;
import cn.edu.upc.study_online.dao.object.StudentDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/4/8.
 */
@Repository
public class StudentDao {
    @Autowired
    private StudentMapper studentMapper;
    public Long insert(StudentDo studentDo){
        return studentMapper.insert(studentDo);
    }

    public StudentDo queryByName(String name){
        return studentMapper.queryByName(name);
    }

    public StudentDo queryById(Long id){
        return studentMapper.queryById(id);
    }

    public Long update(StudentDo studentDo){
        return studentMapper.update(studentDo);
    }

    public Long delete(Long id){
        return studentMapper.delete(id);
    }

    public List<StudentDo> queryAll(){
        return studentMapper.queryAll();
    }
}
