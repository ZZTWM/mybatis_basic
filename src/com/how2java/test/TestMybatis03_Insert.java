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
 * ���� category_
 * @author Administrator
 *
 */
public class TestMybatis03_Insert {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		Category c = new Category();
		c.setName("OPPO");
		session.insert("addCategory",c);
		
		listAll(session);
		
		session.commit();
		session.close();
	}
	
	private static void listAll(SqlSession session){
		List<Category> cs = session.selectList("listCategory");
		for (Category category : cs) {
			System.out.println(category.getName());
		}
	}
}
