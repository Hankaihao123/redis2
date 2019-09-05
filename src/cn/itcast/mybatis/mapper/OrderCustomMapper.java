package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.OrderUserCu;
import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.User;

public interface OrderCustomMapper {
	List<OrderUserCu> findOrderUserResultType();

	List<OrderUserCu> findOrderUserResultMap();

	List<Orders> findOrderAndOrederdetailist();

	List<User> findItemsDetailAndOrder();
	
	List<Orders> findLazyLoadOrderdetails();
}
