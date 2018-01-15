package dp.matrix.dp;

/*

44. Wildcard Matching

Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

Solution :
1. set first column as True , as empty char are same
2. If first char is * , then set first cell as T
3. Id ? or char same then diagonal + 1
4. If * then , top or left , if anyone is true then true

 */
public class WildCardMatching {

	public static void main(String[] args) {
		String s = "aab";
		String p ="a*b";

		WildCardMatching obj = new WildCardMatching();
		System.out.println(obj.isMatch(s,p));
	}
	public boolean isMatch(String s, String p) {


			char[] str = s.toCharArray();
			char[] pat = p.toCharArray();

			boolean[][] cache = new boolean[str.length][pat.length];

			cache[0][0] = true;

			if(pat[0] == '*'){
				cache[0][1] = true;
			}

			for(int i = 1;i < str.length;i++){
				for(int j = 1; j <pat.length;j++){

					if(str[i-1] == pat[j-1] || pat[j- 1] == '?'){
						cache[i][j] = cache[i-1][j-1];
					} else {
						cache[i][j] = cache[i-1][j-1];
					}
				}
			}

			return cache[str.length - 1][pat.length - 1];
	}


}
