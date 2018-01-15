package dp.matrix.dp;

/*

5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s.
You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"

   c  b b d
c  T  F T T
b     T T F
b       T f
d         T
 */

public class PalindromeSubstring {


	public static void main(String[] args) {

		PalindromeSubstring obj = new PalindromeSubstring();
		System.out.println(obj.lengthOfPalindromeSubString("banana"));
	}

	public String lengthOfPalindromeSubString(String str) {

		boolean[][] cache = new boolean[ str.length() ][ str.length() ];

		int maxLen     = 1;
		int startIndex = 0;

		for (int i = 0; i < str.length(); i++) {
			cache[ i ][ i ] = true;
		}

		//Len = 2
		for (int i = 0; i < str.length() - 1; i++) {

			if (str.charAt(i) == str.charAt(i + 1)) {
				maxLen = 2;
				startIndex = i;
				cache[ i ][ i + 1 ] = true;
			}
		}

		for (int jumps = 3; jumps <= str.length(); jumps++) {

			for (int start = 0; start < str.length() - jumps + 1; start++) {

				int end = start + jumps - 1;

				if (str.charAt(start) == str.charAt(end) &&
						cache[ start + 1 ][ end - 1 ]) {

					cache[ start ][ end ] = true;
					startIndex = start;
					maxLen = jumps;
				}
			}

		}

		return str.substring(startIndex, maxLen + 1);

	}


}
