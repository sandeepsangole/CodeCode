package strings;

import java.util.*;

public class WordPattern {

	public static void main(String[] args) {

		WordPattern obj = new WordPattern();
		obj.hashPut();
	}

	public void hashPut(){
		Map index = new HashMap();
		char[] arr = "abbaq".toCharArray();
		for (Integer i = 0; i < arr.length; ++i) {
			System.out.println(index.put(arr[i], i));

		}
		System.out.println();
		String[] arr1 = {"dog","cat","cat","dog","dog"};
		for (Integer i = 0; i < arr1.length; ++i) {
			System.out.println(index.put(arr1[i], i));

		}
	}

	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map index = new HashMap();
		for (Integer i = 0; i < words.length; ++i) {
			System.out.println(index.put(pattern.charAt(i), i));
			System.out.println(index.put(words[ i ], i));
			if (index.put(pattern.charAt(i), i) != index.put(words[ i ], i))
				return false;
		}
		return true;
	}
}
