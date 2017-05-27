package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.dao.mapper.LessonNoteMapper;
import cn.edu.upc.study_online.dao.object.LessonNoteDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Repository
public class LessonNoteDao {
    @Autowired
    private LessonNoteMapper lessonNoteMapper;

    public LessonNoteDo queryById(Long id) {
        return lessonNoteMapper.queryById(id);
    }

    public Long insert(LessonNoteDo lessonNoteDo) {
        return lessonNoteMapper.insert(lessonNoteDo);
    }

    public Long update(LessonNoteDo lessonNoteDo) {
        return lessonNoteMapper.update(lessonNoteDo);
    }

    public Long delete(Long id) {
        return lessonNoteMapper.delete(id);
    }

    public List<LessonNoteDo> queryByContent(@Param("contentId") Long contentId) {
        return lessonNoteMapper.queryByContent(contentId);
    }
}
