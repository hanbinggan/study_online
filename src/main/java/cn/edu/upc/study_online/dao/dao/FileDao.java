package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.dao.mapper.FileMapper;
import cn.edu.upc.study_online.dao.object.FileDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by songqiaolin on 2017/5/21.
 */
@Repository
public class FileDao {
    @Autowired
    private FileMapper fileMapper;

    public Long insert(FileDo fileDo) {
        return fileMapper.insert(fileDo);
    }

    public Long delete(Long id) {
        return fileMapper.delete(id);
    }

    public Long update(FileDo fileDo) {
        return fileMapper.update(fileDo);
    }

    public FileDo queryById(Long id) {
        return fileMapper.queryById(id);
    }
}
