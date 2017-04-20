package cn.edu.upc.study_online.dao.dao;

import cn.edu.upc.study_online.BaseTest;
import cn.edu.upc.study_online.dao.object.StudentDo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by songqiaolin on 2017/4/19.
 */
public class StudentDaoTest extends BaseTest{
    @Autowired
    private StudentDao studentDao;
    @Test
    public void update() throws Exception {
        StudentDo studentDo = studentDao.queryById(1L);
        studentDo.setName("5345435");
        studentDao.update(studentDo);
        System.out.println(studentDo.getName());
    }

}