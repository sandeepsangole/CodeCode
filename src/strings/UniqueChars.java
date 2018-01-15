package strings;

public class UniqueChars {

	public static void main(String[] args) {

		System.out.println(allUnique("sandys"));
	}

	public static boolean allUnique(String str){

		boolean[] charSet = new boolean[256];

		for(char ch :str.toCharArray()){
			if(charSet[ch]){
				return false;
			} else {
				charSet[ch] = true;
			}
		}

		return true;
	}

}
