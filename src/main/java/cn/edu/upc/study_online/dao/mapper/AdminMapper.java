package cn.edu.upc.study_online.dao.mapper;


import cn.edu.upc.study_online.dao.object.AdminDo;
import org.springframework.stereotype.Repository;


/**
 * Created by songqiaolin on 2017/3/26.
 */
@Repository
public interface AdminMapper {
    Long insert(AdminDo adminDo);
    AdminDo queryByName(String name);
}
