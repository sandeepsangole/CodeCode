package strings;

import java.util.*;

public class MinWindow {

	public static void main(String[] args) {
		System.out.println(minWindow("adobecodebanc", "abc"));

	}

	public static String minWindow(String s, String t) {

		String                  res       = "";
		Map<Character, Integer> targetMap = new HashMap<>();

		for (char c : t.toCharArray()) {
			targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> strMap = new HashMap<>();
		int                     start  = 0;
		int                     minLen = Integer.MAX_VALUE;
		int                     count  = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (targetMap.containsKey(c)) {
				if (strMap.containsKey(c)) {
					if (strMap.get(c) < targetMap.get(c)) {
						count++;
					}
					strMap.put(c, strMap.get(c) + 1);
				} else {
					strMap.put(c, 1);
					count++;
				}
			}


			if (count == t.length()) {
				char sc = s.charAt(start);
				while (!strMap.containsKey(sc) || strMap.get(sc) > targetMap.get(sc)) {
					
					if (strMap.containsKey(sc) && strMap.get(sc) > targetMap.get(sc)){
						strMap.put(sc, strMap.get(sc) - 1);
					}
						
					start++;
					sc = s.charAt(start);
				}
				if (i - start + 1 < minLen) {
					res = s.substring(start, i + 1);
					minLen = i - start + 1;
				}
			}
		}

		return res;
	}
}
