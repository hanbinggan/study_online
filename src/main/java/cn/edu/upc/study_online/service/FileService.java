package cn.edu.upc.study_online.service;

import cn.edu.upc.study_online.dao.dao.FileDao;
import cn.edu.upc.study_online.dao.object.FileDo;
import cn.edu.upc.study_online.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;

/**
 * Created by songqiaolin on 2017/5/24.
 */
@Component
public class FileService {
    @Autowired
    private FileDao fileDao;

    public Long saveFile(MultipartFile file) throws IOException {
        try {
            String name = ((CommonsMultipartFile) file).getFileItem().getName();
            String path = FileUtil.saveFile(file);
            FileDo fileDo = new FileDo();
            fileDo.setName(name);
            fileDo.setPath(path);
            fileDao.insert(fileDo);
            return fileDo.getId();
        } catch (IOException e) {
            throw e;
        }
    }

}
