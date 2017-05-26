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
 * Created by songqiaolin on 2017/5/26.
 */
@Component
public class FileServiceImpl implements FileService{
    @Autowired
    private FileDao fileDao;

    public Long saveFile(MultipartFile file) throws IOException {
        try {
            String name = ((CommonsMultipartFile) file).getFileItem().getName();
            String path = FileUtil.saveFile(file);
            FileDo fileDo = new FileDo();
            fileDo.setName(name);
            fileDo.setPath(path);
            fileDo.setType(FileDo.TYPE.OTHER.getVal());
            String last = StringUtil.getSubffix(name);
            if ("pptx".equals(last) || "xlsx".equals(last) || "docx".equals(last)) {
                PdfUtil.convertToPdf(path, last);
                fileDo.setType(FileDo.TYPE.PDF.getVal());
            }else if("pdf".equals(last)){
                fileDo.setType(FileDo.TYPE.PDF.getVal());
            }
            fileDao.insert(fileDo);
            return fileDo.getId();
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public FileDo queryById(Long id) {
        return fileDao.queryById(id);
    }

    @Override
    public Long delete(Long id) {
        FileDo fileDo = fileDao.queryById(id);

        return null;
    }
}
