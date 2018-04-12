package dp.matrix.dp;

public class PalindromeSubsequence {
	public static void main(String[] args) {

		PalindromeSubsequence obj = new PalindromeSubsequence();
		System.out.println(obj.lps("LPASPAL"));
	}

	public int lps(String s) {

		int     len   = s.length();
		int[][] cache = new int[ len ][ len ];
		for (int i = 0; i < len; i++) {
			cache[ i ][ i ] = 1;
		}

		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i + 1) == s.charAt(i)) {
				cache[ i ][ i + 1 ] = 1;
			}
		}

		
		for (int jumps = 3; jumps <= len; jumps++) {
			for (int start = 0; start < len - jumps + 1; start++) {
				int end = start + jumps - 1;
				if (s.charAt(start) == s.charAt(end)) {
					cache[ start ][ end ] = 2 + cache[ start + 1 ][ end - 1 ];
				} else {
					cache[ start ][ end ] = Math.max(cache[ start + 1 ][ end ], cache[ start ][ end - 1 ]);
				}
			}
		}

		return cache[ 0 ][ len - 1 ];
	}
}
