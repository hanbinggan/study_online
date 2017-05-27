package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.dao.mapper.AnswerMapper;
import cn.edu.upc.study_online.dao.object.AnswerDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Repository
public class AnswerDao {
    @Autowired
    private AnswerMapper answerMapper;

    public AnswerDo queryById(Long id) {
        return answerMapper.queryById(id);
    }

    public Long insert(AnswerDo answerDo) {
        return answerMapper.insert(answerDo);
    }

    public Long update(AnswerDo answerDo) {
        return answerMapper.update(answerDo);
    }

    public Long delete(Long id) {
        return answerMapper.delete(id);
    }

    public List<AnswerDo> queryByObject(Integer type, Long objectId) {
        return answerMapper.queryByObject(type, objectId);
    }
}
