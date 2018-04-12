package strings;

import java.util.*;

/*

Longest Substring without repeating characters

abcabcdvb
012345678

 */

public class LongestSubString {

	public static void main(String[] args) {

		System.out.println(longestSubString("abc abcdvb"));
		System.out.println(longestSubString("abcabcbb"));
	}

	public static int longestSubString(String str){

		Map<Character,Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for(int i =0;i<str.length();i++){

			char ch = str.charAt(i);
			if(map.containsKey(ch)){
				max = Math.max(max , map.size());
				i = map.get(ch);
				map.clear();
			} else {
				map.put(ch , i);
			}

		}

		return max = Math.max(max,map.size());

	}

}
