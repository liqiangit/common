package com.liqiang.common.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

public class GroupUtils {
	public static <T> List<Map<String, Object>> groupby(List<T> persons, Key<T> key, List<Operation> operations,boolean listed)
			throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Map<String, Object>> maps = new LinkedHashMap<String, Map<String, Object>>();
		for (T t : persons) {
			Map<String, Object> map = null;
			List<T> ls=null;
			String keyValue = key.getKey(t);
			if (maps.containsKey(keyValue)) {
				map = maps.get(keyValue);
				if(listed){
					ls=(List<T>) map.get("list");
				}
			} else {
				map = new LinkedHashMap<String, Object>();
				if(listed){
					ls=new ArrayList<>();
					map.put("list", ls);
				}
				map.put("key", keyValue);
				maps.put(keyValue, map);
			}
			if(listed){
				ls.add(t);
			}
			for (Operation operation : operations) {
				boolean contains = map.containsKey(operation.getOperationfield());
				String oper = operation.getOperation();
				Object v = map.get(operation.getOperationfield());
				Object v2 = PropertyUtils.getProperty(t, operation.getField());
				if (contains) {
					if (oper.equals("sum")) {
						map.put(operation.getOperationfield(), sum(v, v2));
					}
					if (oper.equals("count")) {
						map.put(operation.getOperationfield(), sum(v, new Integer(1)));
					}
					if (oper.equals("first")) {
						map.put(operation.getOperationfield(), first(v, v2));
					}
					if (oper.equals("last")) {
						map.put(operation.getOperationfield(), last(v, v2));
					}
					if (oper.equals("min")) {
						map.put(operation.getOperationfield(), min(v, v2));
					}
					if (oper.equals("max")) {
						map.put(operation.getOperationfield(), max(v, v2));
					}
				} else {
					map.put(operation.getOperationfield(), v2);
					if (oper.equals("count")) {
						map.put(operation.getOperationfield(), new Integer(1));
					}
				}
			}
		}
		for (Map.Entry<String, Map<String, Object>> entry : maps.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}

	private static Object max(Object v, Object v2) {
		Comparable c = (Comparable) v;
		Comparable c2 = (Comparable) v2;
		int val = c.compareTo(c2);
		if (val > 0) {
			return c;
		} else {
			return c2;
		}
	}

	private static Object min(Object v, Object v2) {
		Comparable c = (Comparable) v;
		Comparable c2 = (Comparable) v2;
		int val = c.compareTo(c2);
		if (val > 0) {
			return c2;
		} else {
			return c;
		}
	}

	private static Object last(Object v, Object v2) {
		return v2;
	}

	private static Object first(Object v, Object v2) {
		return v;
	}

	private static Object sum(Object v, Object v2) {
		if (v == null) {
			return v2;
		}
		if (v2 == null) {
			return v;
		}
		if (v2 instanceof BigDecimal) {
			BigDecimal bv = (BigDecimal) v;
			BigDecimal bv2 = (BigDecimal) v2;
			return bv.add(bv2);
		}
		if (v2 instanceof Integer) {
			return (Integer) v + (Integer) v2;
		}
		if (v2 instanceof Double) {
			return (Double) v + (Double) v2;
		}
		if (v2 instanceof Float) {
			return (Float) v + (Float) v2;
		}
		if (v2 instanceof Long) {
			return (Long) v + (Long) v2;
		}
		return null;
	}
}
