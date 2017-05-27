package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.dao.object.ExerciseDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Repository
public interface ExerciseMapper {
    Long insert(ExerciseDo exerciseDo);
    Long update(ExerciseDo exerciseDo);
    Long delete(Long id);
    ExerciseDo queryById(Long id);
    List<ExerciseDo> queryByChapter(@Param("chapterId") Long chapterId);
}
