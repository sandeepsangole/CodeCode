package strings;

/*

Check if two given strings are isomorphic to each other
2.5
Two strings str1 and str2 are called isomorphic if there is a one to one mapping possible for every character of
str1 to every character of str2. And all occurrences of every character in ‘str1’ map to same character in ‘str2’

Examples:

Input:  str1 = "aab", str2 = "xxy"
Output: True
'a' is mapped to 'x' and 'b' is mapped to 'y'.

Input:  str1 = "aab", str2 = "xyz"
Output: False
One occurrence of 'a' in str1 has 'x' in str2 and
other occurrence of 'a' has 'y'.

 */
public class Isomorphic {

	public static void main(String[] args) {
		System.out.println(isIsomorphic("aab", "xxy"));
	}

	public static boolean isIsomorphic(String s, String t) {
		int[] m1 = new int[126];
		int[] m2 = new int[126];

		int n = s.length();
		for (int i = 0; i < n; i++) {

			if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
				return false;
			}
			m1[s.charAt(i)] = i + 1;
			m2[t.charAt(i)] = i + 1;
		}
		return true;
	}

}
