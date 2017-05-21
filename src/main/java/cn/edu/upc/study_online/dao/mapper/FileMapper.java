package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.dao.object.FileDo;
import org.springframework.stereotype.Repository;

/**
 * Created by songqiaolin on 2017/5/21.
 */
@Repository
public interface FileMapper {
    Long insert(FileDo fileDo);

    Long delete(Long id);

    Long update(FileDo fileDo);

    FileDo queryById(Long id);
}
