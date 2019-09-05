package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.po.User;

public interface UserMapper {
	public User findUserById(int id);

	public int updateUser(User user);
}
