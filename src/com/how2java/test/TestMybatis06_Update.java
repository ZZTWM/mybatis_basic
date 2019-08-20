package com.how2java.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.Category;

/**
 * ÐÞ¸Ä
 * @author Administrator
 *
 */
public class TestMybatis06_Update {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		Category c = session.selectOne("getCategory",3);
		c.setName(c.getName()+ "ÐÞ¸Äºó");
		session.update("updateCategory",c);
		
		listAll(session);
		
		session.commit();
		session.close();
	}

	private static void listAll(SqlSession session) {
		List<Category> cs = session.selectList("listCategory");
		for (Category category : cs) {
			System.out.println(category.getName());
		}
	}
}
