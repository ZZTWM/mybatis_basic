package com.how2java.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.Category;

/**
 * 多条件查询
 * @author Administrator
 *
 */
public class TestMybatis09_Query_Multi_Condition {
	public static void main(String[] args) throws IOException {     
	
		String resource = "mybatis-config.xml";
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    SqlSession session = sqlSessionFactory.openSession();
	
	    Map<String,Object> params = new HashMap<>();
	    params.put("id", 7);
	    params.put("name", "OPPO");
	     
	    List<Category> cs = session.selectList("listCategoryByIdAndName",params);
	    for (Category c : cs) {
	        System.out.println(c.getName());
	    }
	
	    session.commit();
	    session.close();
    
    }
}
















