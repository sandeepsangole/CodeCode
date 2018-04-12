
/*
	Longest Substring without repeating characters
*/

import java.util.*;

public class LongestSubString {

	/*
		Sandeep
		Map babcacdk
                  

	*/
	public static void main(String[] args){
		LongestSubString obj = new LongestSubString();
		//System.out.println(obj.lengthOfLongestSubString("sandeep"));
		System.out.println(obj.lengthOfLongestSubString("anday"));
	}
	public int lengthOfLongestSubString(String str){

		Map<Character,Integer> map = new HashMap<>();

		int maxLen = 0;
		for(int i = 0;i< str.length();i++){

			if(map.containsKey(str.charAt(i))){
				maxLen = Math.max(maxLen , map.size());
				i = map.get(str.charAt(i));
				map.clear();
			} else {
				map.put(str.charAt(i), i);
			}
		}

		return Math.max(maxLen, map.size());
	}
}