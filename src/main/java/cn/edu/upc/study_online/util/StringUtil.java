package cn.edu.upc.study_online.util;

import java.net.FileNameMap;
import java.net.URLConnection;

/**
 * Created by songqiaolin on 2017/5/25.
 */
public class StringUtil {
    public static String getSubffix(String path) {
        if (path == null || !path.contains(".")) {
            return "";
        }
        return path.substring(path.lastIndexOf('.') + 1, path.length());
    }

    public static String getContentType(String name) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String mimeType = fileNameMap.getContentTypeFor(name);
        if (mimeType == null) {
            String ext = getSubffix(name);
            if (name.endsWith(".mp4")) {
                mimeType = "video/" + ext;
            } else if (name.endsWith(".mp3")) {
                mimeType = "audio/mpeg";
            } else if(name.endsWith(".swf")){
                mimeType="application/x-shockwave-flash";
            }else {
                return "";
            }
        }
        return mimeType;
    }
}
