package pramp;

import java.util.*;
/*
Smallest Substring of All Characters
Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring
that finds the smallest substring of str containing all the characters in arr. Return ""
(empty string) if such a substring doesn’t exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.

Example:

input:  arr = ['x','y','z'], str = "xyyzyzyx"

output: "zyx"
 */
public class SubStringWindow {

	public static void main(String[] args) {
		char[] arr = {'x','y','z'};
		String str = "xyyzyzyx";

		System.out.println(getShortestUniqueSubstring(arr,str));
	}


	static String getShortestUniqueSubstring(char[] arr, String str) {

		String                  res    = "";
		Map<Character, Integer> arrMap = new HashMap<>();
		for (char c : arr) {
			if (arrMap.containsKey(c)) {
				arrMap.put(c, arrMap.get(c) + 1);
			} else {
				arrMap.put(c, 1);
			}
		}


		Map<Character , Integer> strMap = new HashMap<>();
		int start = 0;
		int minLen = Integer.MAX_VALUE;
		for(int i = 0; i < str.length() ; i++){

			char c = str.charAt(i);
			if(arrMap.containsKey(c)){
				if(strMap.containsKey(c)){
					strMap.put(c,strMap.get(c) + 1);
				} else {
					strMap.put(c,1);
				}
			}

			if(strMap.size() == arrMap.size()){
				if(minLen > (i - start)) {
					res = str.substring(start, i + 1);
					minLen = i - start;

				}

				i = start;
				start++;
				strMap.clear();
			}
		}

		return res;

	}


}
