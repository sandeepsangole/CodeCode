package strings;

/*
	Given a String s1 and s2 , check s2 is rotation of s1
	eg s1 = abcd , s2 = cdab

	abcdabcd

 */
public class Rotation {

	public static void main(String[] args) {

		System.out.println(isRotation("abcd","abxy"));
	}

	public static boolean isRotation(String s1 , String s2){

		return  s1.length() == s2.length() && (s1 + s1).contains(s2);
	}


}
