package cn.edu.upc.study_online.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by songqiaolin on 2017/5/24.
 */
public class FileUtil {
    public static String path = "/Users/songqiaolin/study_online/file/";

    public static String saveFile(MultipartFile file) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            boolean flag = dir.mkdir();
            if (!flag) {
                throw new IOException();
            }

        }
        String realName = ((CommonsMultipartFile) file).getFileItem().getName();
        String name = UUID.randomUUID().toString();
        realName = "." + StringUtil.getSubffix(realName);
        String filePath = path + name + realName;
        File saveFile = new File(filePath);
        boolean flag = saveFile.createNewFile();
        if (flag) {
            FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();
        } else {
            throw new IOException();
        }
        return filePath;
    }
}
