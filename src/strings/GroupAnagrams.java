package strings;

import java.util.*;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] arr = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(arr));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) return new ArrayList<List<String>>();

		Map<String, List<String>> map = new HashMap<>();

		for (String s : strs) {
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			String key = String.valueOf(arr);

			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
				map.get(key).add(s);


		}

		return new ArrayList<List<String>>(map.values());
	}

}
