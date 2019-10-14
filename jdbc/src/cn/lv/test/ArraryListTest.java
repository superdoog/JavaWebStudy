package cn.lv.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraryListTest {
	public static void main(String[] args) {
//		List list = new ArrayList<>();
//		list.add(10);
//		list.add(20);
//		list.add(30);
//		System.out.println(list.size());
//
//		list.add("abc");
//
//
//		System.out.println(list.get(0));
//
//		list.remove(0);
//		System.out.println(list.size());
//		System.out.println(list.get(0));
//		System.out.println(list.get(2));

		Map<String, Integer> map = new HashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);

		System.out.println(map.containsKey("a"));
		System.out.println(map.containsValue(3));
		System.out.println(map.get("a"));

		for (Map.Entry<String, Integer> entry:map.entrySet()){
			System.out.println(entry.getKey()+"-----"+entry.getValue());
		}
	}
}
