package cn.edu.upc.study_online.dao.mapper;

import cn.edu.upc.study_online.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by songqiaolin on 2017/5/27.
 */
public class AnswerMapperTest extends BaseTest {
    @Autowired
    private AnswerMapper answerMapper;

    @Test
    public void queryById() throws Exception {
        answerMapper.queryById(1L);
    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void queryByObject() throws Exception {
        answerMapper.queryByObject(1,1L);
    }

}