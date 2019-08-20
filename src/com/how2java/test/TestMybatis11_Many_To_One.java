package com.how2java.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.Product;
/**
 * ���һ
 * @author Administrator
 *
 */
public class TestMybatis11_Many_To_One {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		List<Product> ps = session.selectList("listProduct_Many_To_One");
		for (Product product : ps) {
			System.out.println(product + "��Ӧ�ķ����ǣ�" + product.getCategory());
		}
		
		session.commit();
		session.close();
	}
}
