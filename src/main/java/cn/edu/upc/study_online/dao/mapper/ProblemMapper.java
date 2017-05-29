package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.dao.object.ProblemDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Repository
public interface ProblemMapper {
    ProblemDo queryById(Long id);

    Long insert(ProblemDo problemDo);

    Long update(ProblemDo problemDo);

    Long delete(Long id);

    List<ProblemDo> queryByObject(@Param("type") Integer type, @Param("objectId") Long objectId);

    Long deleteByObjectType(@Param("objectId") Long objectId, @Param("type") Integer type);
}
