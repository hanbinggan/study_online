package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.dao.mapper.LessonMapper;
import cn.edu.upc.study_online.dao.object.LessonDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/19.
 */
@Repository
public class LessonDao {
    @Autowired
    private LessonMapper lessonMapper;

    public LessonDo queryById(Long id) {
        return lessonMapper.queryById(id);
    }

    public Long insert(LessonDo lessonDo){
        return lessonMapper.insert(lessonDo);
    }

    public Long update(LessonDo lessonDo){
        return lessonMapper.update(lessonDo);
    }

    public Long delete(Long id){
        return lessonMapper.delete(id);
    }

    public List<LessonDo> selectByCreator(Long creatorId){
        return selectByCreator(creatorId);
    }
}
