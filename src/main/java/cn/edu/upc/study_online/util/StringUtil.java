package cn.edu.upc.study_online.util;

/**
 * Created by songqiaolin on 2017/5/25.
 */
public class StringUtil {
    public static String getSubffix(String path) {
        if (path == null || path.contains(".")) {
            return "";
        }
        return path.substring(path.lastIndexOf('.') + 1, path.length());
    }
}
