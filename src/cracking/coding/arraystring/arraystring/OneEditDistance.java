package cracking.coding.arraystring.arraystring;

public class OneEditDistance {
	public static void main(String[] args) {

		System.out.println(isOneEditDistance("a","ab"));

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

		if((s == null || s.length() ==0) && (t == null || t.length() == 0)){
			return false;
		}

		int sLen = s.length();
		int tLen = t.length();

		int diff = Math.abs(sLen - tLen);
		if(diff > 1){
			return false;
		}

		int i = 0;
		int j = 0;
		boolean once = false;

		while(i < sLen && j < tLen){

			if(s.charAt(i) == t.charAt(j)){
				i++;
				j++;
			} else {
				if(once){
					return false;
				} else {
					once = true;
				}
				
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

		if((i <sLen || j < tLen)  && !once){
			return false;
		}

		return once || (!once && diff > 1) ;
	}
}
