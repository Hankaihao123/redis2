package cn.itcast.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSON;

import cn.itcast.mybatis.mapper.ResourceMapper;
import cn.itcast.mybatis.test.pojo.Resource;
import cn.itcast.mybatis.test.pojo.Role;

public class test3 {
	public static void main(String[] args) throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession session = sqlsessionfactory.openSession();
		ResourceMapper mapper = session.getMapper(ResourceMapper.class);
		Role role = mapper.findAllPerss(1);
		List<Resource> resourcelist = role.getResourcelist();
		List<Resource> tree = toTree(resourcelist);
		role.setResourcelist(tree);
		System.out.println(tree.toString());
		String objJsonStr = JSON.toJSONString(tree);
		System.err.println(objJsonStr);
	}

	// 将线性结构转换成子父节点
	public static List<Resource> toTree(List<Resource> list) {
		List<Resource> Root = new ArrayList<Resource>();
		for (Resource res : list) {
			// 如果当前是根节点下父节点那么就直接在根上增加数据
			if (res.getParentId() == 0) {
				if (!isExist(Root, res)) {
					Root.add(res);
				}
				continue;
			}
			// 不是父节点就查询当前子节点的父节点
			Resource currParent = findParent(list, res);
			if (res != currParent) {
				// 把当前子节点赋给父节点
				if (currParent.getChildren() == null) {
					currParent.setChildren(new ArrayList<Resource>());
					currParent.getChildren().add(res);
				} else {
					currParent.getChildren().add(res);
				}
			}
		}
		return Root;
	}

	// 查询当前节点的的父节点
	public static Resource findParent(List<Resource> list, Resource r) {
		if (list == null || r == null) {
			throw new NullPointerException();
		}
		for (Resource resource : list) {
			if (resource == r) {
				continue;
			} else if (resource.getMenuId() == r.getParentId()) {
				return resource;
			}
		}
		// 如果是null说明是要节点下的头节点
		return null;
	}

	// 判断该父节点是否存在
	public static boolean isExist(List<Resource> list, Resource r) {
		if (list == null || list.size() == 0) {
			return false;
		}
		for (int i = 0; i < list.size(); i++) {
			if (r == list.get(i)) {
				return true;
			}
		}
		return false;
	}

}
