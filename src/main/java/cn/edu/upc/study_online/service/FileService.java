package cn.edu.upc.study_online.service;

import cn.edu.upc.study_online.dao.dao.FileDao;
import cn.edu.upc.study_online.dao.object.FileDo;
import cn.edu.upc.study_online.util.FileUtil;
import cn.edu.upc.study_online.util.PdfUtil;
import cn.edu.upc.study_online.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;

/**
 * Created by songqiaolin on 2017/5/24.
 */
public interface FileService {
    Long saveFile(MultipartFile file) throws IOException;

    FileDo queryById(Long id);

    Long delete(Long id);
}
