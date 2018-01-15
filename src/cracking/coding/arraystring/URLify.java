package cracking.coding.arraystring;


//""Mr John _ % 2 0 S  m  t t h"

public class URLify {

	public static void main(String[] args) {
		URLify obj = new URLify();
		System.out.println(obj.urlify("Mr John Smith    ", 13));
		System.out.println(obj.urlify(" abc  ", 4));
		System.out.println(obj.urlify("abc", 3));
	}

	public String urlify(String str, int len) {

		int    end = str.length() - 1;
		char[] arr = str.toCharArray();

		for (int i = len - 1; i >= 0; i--) {

			if (arr[ i ] != ' ') {
				arr[ end ] = arr[ i ];
				end--;
			} else {
				arr[ end ] = '0';
				arr[ end - 1 ] = '2';
				arr[ end - 2 ] = '%';
				end = end - 3;
			}

		}

		return String.valueOf(arr);
	}


}
