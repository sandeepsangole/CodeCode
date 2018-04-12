package cracking.coding.arraystring;

public class OneAway {
	public static void main(String[] args) {
		System.out.println(isOneEditDistance("a", ""));
		System.out.println(isOneEditDistance("", ""));
		System.out.println(isOneEditDistance("c", "c"));

	}

	public static boolean isOneEditDistance(String s, String t) {

		char[] sc   = s.toCharArray();
		char[] tc   = t.toCharArray();
		int    m    = sc.length, n = tc.length;
		int    diff = Math.abs(m - n);
		if (diff > 1) return false;

		int     i    = 0, j = 0;
		boolean once = false;
		while (i < m && j < n) {
			if (sc[ i ] != tc[ j ]) {
				if (!once) {
					once = true;
				} else {
					return false;
				}

				if (m > n) {
					i++;
				} else if (m < n) {
					j++;
				} else {
					i++;
					j++;
				}

			} else {
				i++;
				j++;
			}

		}
		return once || (!once && diff == 1);
	}
}

