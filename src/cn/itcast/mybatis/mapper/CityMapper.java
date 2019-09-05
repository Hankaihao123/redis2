package cn.itcast.mybatis.mapper;

import java.util.List;
import java.util.Map;

public interface CityMapper {

	// 查询所有的父级信息
	List<Map<String, Object>> findParentInfo(Map<String, Object> param);

	// 递归查询所有下面的子级信息
	List<Map<String, Object>> findSonInfo(Map<String, Object> param);
}
