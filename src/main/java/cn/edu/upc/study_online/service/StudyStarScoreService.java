package cn.edu.upc.study_online.service;

import cn.edu.upc.study_online.dao.object.StudyStarScoreDo;

/**
 * Created by songqiaolin on 2017/5/28.
 */
public interface StudyStarScoreService {
    StudyStarScoreDo getStarScore(Long lessonId, Integer type);
    void setStarScore(Long lessonId, Integer type, Integer score);
}
