package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.BaseTest;
import cn.edu.upc.study_online.dao.object.Admin;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by songqiaolin on 2017/3/26.
 */
public class AdminDaoTest extends BaseTest{
    @Autowired
    private AdminDao adminDao;
    @Test
    public void insert() throws Exception {
        Admin admin = new Admin();
        admin.setName("admin");
        admin.setPassword("admin");
        adminDao.insert(admin);
    }

    @Test
    public void select() throws Exception{
        Admin admin = adminDao.selectByName("admin");
        assertNull(admin);
    }

}