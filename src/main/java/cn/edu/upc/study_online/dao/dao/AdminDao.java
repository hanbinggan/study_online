package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.dao.mapper.AdminMapper;
import cn.edu.upc.study_online.dao.object.AdminDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by songqiaolin on 2017/3/26.
 */
@Repository
public class AdminDao {
    @Autowired
    private AdminMapper adminMapper;

    public Long insert(AdminDo adminDo) {
        return adminMapper.insert(adminDo);
    }

    public AdminDo selectByName(String name){
        return adminMapper.queryByName(name);
    }
}
