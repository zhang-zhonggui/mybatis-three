package com.zzg.test;

import com.zzg.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class JavaTest {
    SqlSession sqlSession;

    @Before
    public void before() throws Exception {
        String path = "mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(path);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = factory.openSession();
    }

    @After
    public void end() {
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students =mapper.queryStudent();
        System.out.println(students);
    }
}
