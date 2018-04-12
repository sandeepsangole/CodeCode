package cracking.coding.arraystring.arraystring;

public class UniqueChars {

	public static void main(String[] args) {

		System.out.println(allUnique("sandyS"));
	}

	public static boolean allUnique(String str){

		boolean[] charSet = new boolean[26];

		for(char ch :str.toCharArray()){
			if(charSet[ch - 'a']){
				return false;
			} else {
				charSet[ch - 'a'] = true;
			}
		}

		return true;
	}

}
