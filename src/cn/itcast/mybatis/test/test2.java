package cn.itcast.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSON;

import cn.itcast.mybatis.mapper.CityMapper;

public class test2 {
	// 查询指定所有的中国 所有的省市区信息
	public static void main(String[] args) throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession session = sqlsessionfactory.openSession();
		CityMapper mapper = session.getMapper(CityMapper.class);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", -1);
		List<Map<String, Object>> list = mapper.findParentInfo(param);
		System.out.println(list);
		digui(list, mapper);
		String objJsonStr = JSON.toJSONString(list);
		System.out.println(objJsonStr);
	}

	// list是引用传递,形参修改导致实参也是会修改的
	public static void digui(List<Map<String, Object>> list, CityMapper mapper) {
		if (list.size() == 0) {
			return;
		}
		for (Map<String, Object> map : list) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", map.get("id"));
			list = mapper.findSonInfo(param);
			if (list.size() != 0) {
				map.put("children", list);
			}
			System.err.println(list);
			digui(list, mapper);
		}

	}
}
