package com.how2java.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.Order;
import com.how2java.pojo.OrderItem;
/**
 * 多对多：查询操作
 * @author Administrator
 *
 */
public class TestMybatis12_Many_To_Many_QueryOperation {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		listOrder(session);
		
		session.commit();
		session.close();
	}
	
	/**
	 * 查询
	 * @param session
	 */
	private static void listOrder(SqlSession session) {
		List<Order> os = session.selectList("listOrder");
		for (Order order : os) {
			System.out.println(order.getCode());
			List<OrderItem> ois = order.getOrderItems();
			for (OrderItem orderItem : ois) {
				System.out.format("\t%s\t%f\t%d%n", orderItem.getProduct().getName(),orderItem.getProduct().getPrice(),orderItem.getNumber());
			}
		}
		
	}
	
}
