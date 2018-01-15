package strings;

public class OneEditDistance {
	public static void main(String[] args) {

		System.out.println(isOneEditDistance("sandy","andy"));
		System.out.println(isOneEditDistance("egg","add"));
		System.out.println(isOneEditDistance("sandy","ancdy"));
	}

	/*

		agdy
		   j
		aggy
		   i
		1. if diff in length less than 1
		2. 2 pointers
		3. in case of diff incrase count and increment pointer for string with loner string

	 */
	public static boolean isOneEditDistance(String s , String t){

		if(s == null || s.length() ==0 || t == null || t.length() == 0){
			return false;
		}

		int sLen = s.length();
		int tLen = t.length();

		if(Math.abs(sLen - tLen) > 1){
			return false;
		}

		int i = 0;
		int j = 0;
		int count = 0;

		while(i < sLen && j < tLen){

			if(s.charAt(i) == t.charAt(j)){
				i++;
				j++;
			} else {
				count++;
				if (sLen > tLen) {
					i++;
				} else if (tLen > sLen) {
					j++;
				} else {
					i++;
					j++;
				}
			}
		}

		if(i <sLen || j < tLen  && count > 0){
			return false;
		}

		return count <= 1 ;
	}
}
