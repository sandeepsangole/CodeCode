package cracking.coding.arraystring.arraystring;

public class StringCompression {

	public static void main(String[] args) {

		System.out.println(compressString("aabcccccaaa"));
	}

	public static String compressString(String str){

		int count = 1;
		int i = 0;
		StringBuilder sb = new StringBuilder();
		for (;i<str.length() - 1;i++){

			if (str.charAt(i) == str.charAt(i + 1)){
				count++;
			} else {
				sb.append(str.charAt(i)).append(count);
				count = 1;
			}
		}

		sb.append(str.charAt(i)).append(count);
		return sb.toString();
	}
}
