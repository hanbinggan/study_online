package cn.edu.upc.study_online.service;

import cn.edu.upc.study_online.dao.dao.StudyStarScoreDao;
import cn.edu.upc.study_online.dao.object.StudyStarScoreDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by songqiaolin on 2017/5/28.
 */
@Component
public class StudyStarScoreServiceImpl implements StudyStarScoreService {
    @Autowired
    private StudyStarScoreDao studyStarScoreDao;

    @Override
    public StudyStarScoreDo getStarScore(Long lessonId, Integer type) {
        StudyStarScoreDo studyStarScoreDo = studyStarScoreDao.queryByLessonType(lessonId, type);
        if (studyStarScoreDo == null){
            studyStarScoreDo = new StudyStarScoreDo();
            studyStarScoreDo.setPrecent(0);
            studyStarScoreDo.setLessonId(lessonId);
            studyStarScoreDo.setType(type);
            studyStarScoreDao.insert(studyStarScoreDo);
        }
        return studyStarScoreDo;
    }

    @Override
    public void setStarScore(Long lessonId, Integer type, Integer score) {
        StudyStarScoreDo studyStarScoreDo = this.getStarScore(lessonId, type);
        studyStarScoreDo.setPrecent(score);
        studyStarScoreDao.update(studyStarScoreDo);
    }
}
