package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.dao.object.AnswerDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Repository
public interface AnswerMapper {
    AnswerDo queryById(Long id);

    Long insert(AnswerDo answerDo);

    Long update(AnswerDo answerDo);

    Long delete(Long id);

    List<AnswerDo> queryByObject(@Param("type") Integer type, @Param("objectId") Long objectId);

    AnswerDo queryByProblem(@Param("problemId") Long problemId);
}
