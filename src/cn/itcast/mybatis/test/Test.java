package cn.itcast.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.itcast.mybatis.mapper.OrderCustomMapper;
import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.po.OrderUserCu;
import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.User;

public class Test {

	// 用resultType关联查询 一对一
	public static void main2(String[] args) throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession session = sqlsessionfactory.openSession();
		OrderCustomMapper mapper = session.getMapper(OrderCustomMapper.class);
		List<OrderUserCu> list = mapper.findOrderUserResultType();

		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
	}

	// resultMap一对一查询
	public static void main3(String[] args) throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession session = sqlsessionfactory.openSession();
		OrderCustomMapper mapper = session.getMapper(OrderCustomMapper.class);
		List<OrderUserCu> list = mapper.findOrderUserResultMap();

		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));

	}

	// 一对多的映射
	public static void main4(String[] args) throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession session = sqlsessionfactory.openSession();
		OrderCustomMapper mapper = session.getMapper(OrderCustomMapper.class);
		List<Orders> list = mapper.findOrderAndOrederdetailist();

		System.out.println(list.get(0));
		System.out.println(list.get(1));
		// System.out.println(list.get(2));

	}

	// 多对多映射
	public static void main5(String[] args) throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession session = sqlsessionfactory.openSession();
		OrderCustomMapper mapper = session.getMapper(OrderCustomMapper.class);
		List<User> list = mapper.findItemsDetailAndOrder();

		User user = list.get(0);
		System.out.println(user.getOrderslist());

		// System.out.println(list.get(1));
		// System.out.println(list.get(2));

	}

	// 延迟加载
	public static void main6(String[] args) throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession session = sqlsessionfactory.openSession();
		OrderCustomMapper mapper = session.getMapper(OrderCustomMapper.class);
		List<Orders> list = mapper.findLazyLoadOrderdetails();
		for (Orders orders : list) {
			System.out.println(orders.getUser());
			System.out.println(orders.getOrederdetaillist());
		}
	}

	// 测试一级缓存
	public static void main7(String[] args) throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession session = sqlsessionfactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);

		User user1 = mapper.findUserById(1);
		System.out.println(user1);

		// user1.setUsername("五");
		// mapper.updateUser(user1);
		// session.commit();

		User user2 = mapper.findUserById(1);
		System.out.println(user2);
	}

	// 测试二级缓存
	public static void main(String[] args) throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession sqlSession1 = sqlsessionfactory.openSession();
		SqlSession sqlSession2 = sqlsessionfactory.openSession();
		SqlSession sqlSession3 = sqlsessionfactory.openSession();
		
		UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
		
		User user1 = mapper1.findUserById(1);
		System.out.println(user1);
		//只有关闭了SqlSession才能将数据写入到二级缓存
		sqlSession1.close();

		//sqlSession3来执行有关事务的操作就会刷新二级缓存
		// user1.setUsername("五");
		// mapper3.updateUser(user1);
		// sqlSession3.commit();
	
		
		User user2 = mapper2.findUserById(1);
		System.out.println(user1);
	}

}
