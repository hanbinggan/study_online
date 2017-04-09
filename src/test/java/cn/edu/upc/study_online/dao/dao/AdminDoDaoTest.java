package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.BaseTest;
import cn.edu.upc.study_online.dao.object.AdminDo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by songqiaolin on 2017/3/26.
 */
public class AdminDoDaoTest extends BaseTest{
    @Autowired
    private AdminDao adminDao;
    @Test
    public void insert() throws Exception {
        AdminDo adminDo = new AdminDo();
        adminDo.setName("admin1");
        adminDo.setPassword("admin1");
        adminDao.insert(adminDo);
    }

    @Test
    public void select() throws Exception{
        AdminDo adminDo = adminDao.selectByName("admin");
        assertNotNull(adminDo);
        System.out.println(adminDo.getPassword());
    }

}