package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.dao.mapper.StudyStarScoreMapper;
import cn.edu.upc.study_online.dao.object.StudyStarScoreDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Repository
public class StudyStarScoreDao {
    @Autowired
    private StudyStarScoreMapper studyStarScoreMapper;

    public StudyStarScoreDo queryById(Long id) {
        return studyStarScoreMapper.queryById(id);
    }

    public Long insert(StudyStarScoreDo studyStarScoreDo) {
        return studyStarScoreMapper.insert(studyStarScoreDo);
    }

    public Long update(StudyStarScoreDo studyStarScoreDo) {
        return studyStarScoreMapper.update(studyStarScoreDo);
    }

    public StudyStarScoreDo queryByLessonType(Long lessonId, Integer type) {
        return studyStarScoreMapper.queryByLessonType(lessonId, type);
    }
}
