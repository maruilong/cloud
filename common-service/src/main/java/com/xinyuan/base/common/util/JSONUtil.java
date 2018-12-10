package com.xinyuan.base.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JSONUtil {

	// 定义jackson对象
	private static final ObjectMapper mapper = new ObjectMapper();
	/**
	 * 将对象转换成json字符串
	 * @param data
	 * @return
	 */
	public static String toJSONString(Object data) {
		try {
			String string = mapper.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将json结果集转化为对象
	 * @param jsonData
	 * @param beanType
	 * @return
	 */
	public static <T> T parseObject(String jsonData, Class<T> beanType) {
		try {
			T t = mapper.readValue(jsonData, beanType);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将json数据转换成list
	 * @param jsonData
	 * @param beanType
	 * @return
	 */
	public static <T> List<T> parseArray(String jsonData, Class<T> beanType) {
		JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, beanType);
		try {
			List<T> list = mapper.readValue(jsonData, javaType);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
