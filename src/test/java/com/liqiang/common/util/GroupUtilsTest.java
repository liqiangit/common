package com.liqiang.common.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class GroupUtilsTest {

	@Test
	public void test() throws Exception {
		List<Operation> operations = new ArrayList<Operation>();
		{
			Operation operation = new Operation("sum", "age");
			operations.add(operation);
		}
		{
			Operation operation = new Operation("count", "age");
			operations.add(operation);
		}
		{
			Operation operation = new Operation("first", "age");
			operations.add(operation);
		}
		{
			Operation operation = new Operation("last", "age");
			operations.add(operation);
		}
		{
			Operation operation = new Operation("min", "age");
			operations.add(operation);
		}
		{
			Operation operation = new Operation("max", "age");
			operations.add(operation);
		}
		{
			Operation operation = new Operation("sum", "money");
			operations.add(operation);
		}
		{
			Operation operation = new Operation("count", "money");
			operations.add(operation);
		}
		{
			Operation operation = new Operation("first", "money");
			operations.add(operation);
		}
		{
			Operation operation = new Operation("last", "money");
			operations.add(operation);
		}
		{
			Operation operation = new Operation("min", "money");
			operations.add(operation);
		}
		{
			Operation operation = new Operation("max", "money");
			operations.add(operation);
		}
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 100; i++) {
			Person person = new Person();
			person.setName(i % 10 + "");
			person.setAge(i);
			person.setMoney(new BigDecimal(i+".3"));
			persons.add(person);
		}
		List<Map<String, Object>> list = GroupUtils.groupby(persons, new Key<Person>() {

			@Override
			public String getKey(Person person) {
				return person.getName();
			}
		}, operations,false);
		System.out.println(JSON.toJSONString(list));
	}

}
