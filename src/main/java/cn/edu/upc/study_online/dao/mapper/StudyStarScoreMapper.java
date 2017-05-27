package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.dao.object.StudyStarScoreDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Repository
public interface StudyStarScoreMapper {
    StudyStarScoreDo queryById(Long id);

    Long insert(StudyStarScoreDo studyStarScoreDo);

    Long update(StudyStarScoreDo studyStarScoreDo);

    List<StudyStarScoreDo> queryByLesson(@Param("lessonId") Long lessonId);
}
