package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.dao.object.StudyRecordDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Repository
public interface StudyRecordMapper {
    StudyRecordDo queryById(Long id);

    Long insert(StudyRecordDo studyRecordDo);

    Long update(StudyRecordDo studyRecordDo);

    Long delete(Long id);

    List<StudyRecordDo> queryByLessonStudent(@Param("lessonId") Long lessonId,
                                             @Param("studentId") Long studentId);

    StudyRecordDo queryByObjectStudent(@Param("type") Integer type, @Param("objectId") Long objectId,
                                       @Param("studentId") Long studentId);

}
