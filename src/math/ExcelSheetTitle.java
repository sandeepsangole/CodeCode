package math;

public class ExcelSheetTitle {

	public static void main(String[] args) {
		System.out.println(convertToTitle(28));
		System.out.println(titleToNumber("AB"));
	}

	public static String convertToTitle(int n) {
		StringBuilder result = new StringBuilder();
		while (n > 0) {
			n--;
			result.append((char) ('A' + n % 26));
			n /= 26;
		}
		result.reverse();
		return result.toString();
	}

	public static int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = result * 26 + (s.charAt(i) - 'A' + 1);
		}
		return result;
	}
}
