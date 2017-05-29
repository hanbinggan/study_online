package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.dao.mapper.ProblemMapper;
import cn.edu.upc.study_online.dao.object.ProblemDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Repository
public class ProblemDao {
    @Autowired
    private ProblemMapper problemMapper;
    public ProblemDo queryById(Long id){
        return problemMapper.queryById(id);
    }

    public Long insert(ProblemDo problemDo){
        return problemMapper.insert(problemDo);
    }


    public Long update(ProblemDo problemDo){
        return problemMapper.update(problemDo);
    }

    public Long delete(Long id){
        return problemMapper.delete(id);
    }

    public List<ProblemDo> queryByObject(Integer type, Long objectId){
        return problemMapper.queryByObject(type, objectId);
    }

    public Long deleteByObjectType(Long objectId, Integer type){
        return problemMapper.deleteByObjectType(objectId, type);
    }
}
