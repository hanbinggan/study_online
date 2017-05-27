package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.dao.mapper.ExerciseMapper;
import cn.edu.upc.study_online.dao.object.ExerciseDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Repository
public class ExerciseDao {
    @Autowired

    private ExerciseMapper exerciseMapper;

    public Long insert(ExerciseDo exerciseDo) {
        return exerciseMapper.insert(exerciseDo);
    }

    public Long update(ExerciseDo exerciseDo) {
        return exerciseMapper.update(exerciseDo);
    }

    public Long delete(Long id) {
        return exerciseMapper.delete(id);
    }

    public ExerciseDo queryById(Long id) {
        return exerciseMapper.queryById(id);
    }

    public List<ExerciseDo> queryByChapter(@Param("chapterId") Long chapterId) {
        return exerciseMapper.queryByChapter(chapterId);
    }
}
