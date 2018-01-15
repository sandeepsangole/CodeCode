package Permutations;

/*

131. Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]

 */

import java.util.*;

public class PalindromePartition {
	public static void main(String[] args) {
		PalindromePartition obj = new PalindromePartition();
		obj.partition("aab");
	}

	public List<List<String>> partition(String s) {
		List<List<String>> list = new ArrayList<>();
		findPalindromes(list, new ArrayList<>(), s, 0);

		list.stream().forEach(System.out::println);

		return list;
	}

	public void findPalindromes(List<List<String>> res , List<String> subLst , String s , int start){

		if(start == s.length()) {
			res.add(new ArrayList<>(subLst));
		}
		else {
			for (int i = start; i < s.length(); i++) {

				if (isPalindrome(s, start, i)) {
					subLst.add(s.substring(start, i + 1));
					findPalindromes(res, subLst, s, i + 1);
					subLst.remove(subLst.size() - 1);
				}
			}
		}
	}

	public boolean isPalindrome(String s , int left , int right){

		while (left < right){
			if(s.charAt(left ++)  != s.charAt(right--))
			{
				return false;
			}

		}
		return true;
	}
}
