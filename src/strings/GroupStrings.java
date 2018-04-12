package strings;

import java.util.*;

public class GroupStrings {

	public static void main(String[] args) {
		GroupStrings       obj = new GroupStrings();
		String[]           arr = { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };
		List<List<String>> res = obj.groupStrings(arr);
		res.stream().forEach(System.out::println);
	}

	public List<List<String>> groupStrings(String[] strings) {

		Map<String, List<String>> map = new HashMap<>();
		for (String s : strings) {
			String       key  = getKey(s);
			List<String> list = map.getOrDefault(key, new ArrayList<>());
			list.add(s);
			map.put(key, list);
		}

		return new ArrayList<>(map.values());
	}

	public String getKey(String s) {

		char[] carr = s.toCharArray();
		String key  = "";
		for (int i = 1; i < carr.length; i++) {
			int diff = carr[ i ] - carr[ i - 1 ];
			key += diff < 0 ? diff + 26 : diff;
		}

		return key;
	}

}
