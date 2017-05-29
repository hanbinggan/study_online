package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.dao.mapper.StudyRecordMapper;
import cn.edu.upc.study_online.dao.object.StudyRecordDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Repository
public class StudyRecordDao {
    @Autowired
    private StudyRecordMapper studyRecordMapper;

    public StudyRecordDo queryById(Long id) {
        return studyRecordMapper.queryById(id);
    }

    public Long insert(StudyRecordDo studyRecordDo) {
        return studyRecordMapper.insert(studyRecordDo);
    }

    public Long update(StudyRecordDo studyRecordDo) {
        return studyRecordMapper.update(studyRecordDo);
    }

    public Long delete(Long id) {
        return studyRecordMapper.delete(id);
    }

    public List<StudyRecordDo> queryByLesson(Long lessonId) {
        return studyRecordMapper.queryByLesson(lessonId);
    }

    public StudyRecordDo queryByObjectStudent(Integer type, Long objectId, Long studentId) {
        return studyRecordMapper.queryByObjectStudent(type, objectId, studentId);
    }

}
