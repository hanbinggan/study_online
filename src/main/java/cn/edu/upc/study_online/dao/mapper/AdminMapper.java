package cn.edu.upc.study_online.dao.mapper;


import cn.edu.upc.study_online.dao.object.Admin;


/**
 * Created by songqiaolin on 2017/3/26.
 */
public interface AdminMapper {
    Long insert(Admin admin);
    Admin queryByName(String name);
}
