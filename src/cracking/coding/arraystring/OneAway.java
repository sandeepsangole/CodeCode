package cracking.coding.arraystring;

public class OneAway {
	public static void main(String[] args) {
		System.out.println(isOneEditDistance("pale","ple"));
		System.out.println(isOneEditDistance("cake","bake"));
		System.out.println(isOneEditDistance("sandy","andyd"));
	}

	public static boolean isOneEditDistance(String str1, String str2){

		if(str1==null) return false;
		if(str2==null) return false;

		int len1 = str1.length();
		int len2 = str2.length();

		if(Math.abs(len1-len2) > 1){
			return false;
		}

		int i = 0;
		int j =0;
		int count = 0;
		while(i < len1 && j < len2){

			if(str1.charAt(i) == str2.charAt(j)){
				i++;
				j++;
			} else {
				count++;
				if(count > 1){
					return false;
				}

				if(len1 > len2){
					i++;
				} else if(len2> len1){
					j++;
				} else {
					i++;
					j++;
				}
			}
		}

		while(i < len1) {
			count++;
		}

		while ((j < len2)){
			count++;
		}

		return count <= 1;

	}
}

