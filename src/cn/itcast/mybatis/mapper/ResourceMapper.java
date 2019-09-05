package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.test.pojo.Role;

public interface ResourceMapper {

	// 查询当前用户下所有的资源权限
	Role findAllPerss(Integer userid);
}
