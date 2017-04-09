package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.BaseTest;
import cn.edu.upc.study_online.dao.object.AdminDo;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by songqiaolin on 2017/3/26.
 */
public class AdminDoMapperTest extends BaseTest {
    @Autowired
    private AdminMapper adminMapper;
    @org.junit.Test
    public void insert() throws Exception {
        assertNotNull(adminMapper);
        AdminDo adminDo = new AdminDo();
        adminDo.setName("admin");
        adminDo.setPassword("admin");
        adminMapper.insert(adminDo);
    }

    @org.junit.Test
    public void queryByName() throws Exception {
        AdminDo adminDo = adminMapper.queryByName("admin");
        System.out.println(adminDo);
    }

}