package strings;

/*

139. Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.
You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

 */

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class WordBreak {

	public static void main(String[] args) {
		String       s   = "leetcode";
		List<String> dic = new ArrayList<>();
		//dic.add("cat");

		dic.add("leet");
		dic.add("code");
	
		WordBreak obj = new WordBreak();
		System.out.println(obj.wordBreak(s, dic));
	}

	public boolean wordBreak(String s, List<String> wordDic) {
		return wordBreakUtil(s, new HashSet<>(wordDic), 0, new Boolean[ s.length() ]);
	}
	
	
	

	public boolean wordBreakUtil(String s, Set<String> wordDic, int start, Boolean[] memo) {
		if (start == s.length()) {
			return true;
		}

		if (memo[ start ] != null) {
			return memo[ start ];
		}

		for (int i = start + 1; i <= s.length(); i++) {
			System.out.println(i +" "+start +" " +s.substring(start, i));
			if (wordDic.contains(s.substring(start, i)) && wordBreakUtil(s, wordDic, i, memo)){
				return memo[ start ] = true;
			}
		}

		return memo[ start ] = false;
	}
}