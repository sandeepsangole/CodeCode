package strings;

/*
	Find index of all permutations of shorter string within longer one.
 */

import java.util.*;

public class IndexOfAnagramString {

	public static void main(String[] args) {
		IndexOfAnagramString obj = new IndexOfAnagramString();
		List<Integer> res = obj.findIndexOfAnagram("abc","sacbasdfcab");
		res.stream().forEach(System.out::println);
	}

	public List<Integer> findIndexOfAnagram(String anagram , String mainStr){

		int len = anagram.length();
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i <= mainStr.length() - len ; i++){

			int end = i + len;
			if(isPermutation(anagram, mainStr.substring(i,end))){
				res.add(i);
			}
		}

		return res;
	}

	public boolean isPermutation(String str1 , String str2){

		if(str1.length() != str2.length()){
			return false;
		}

		char[] str1Array = str1.toCharArray();
		char[] str2Array = str2.toCharArray();

		int[] arr = new int[256];

		for(char c : str1Array){
			arr[c]++;
		}

		for(char c : str2Array){
			arr[c]--;
		}

		for (int i : arr){
			if(i != 0){
				return false;
			}
		}

		return true;
	}
}

