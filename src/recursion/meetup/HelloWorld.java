package recursion.meetup;

import array.SearchRotatedArray;

public class HelloWorld {

	public static void main(String[] args) {
		printHelloWorld(10);

		System.out.println(baseExp(5,2));
		System.out.println(factorial(5));

		System.out.println(mysteryNumber(777));
		System.out.println(mysteryNumber(1043));
		System.out.println(newPalindrome("Sandy"));
		System.out.println(newPalindrome("NITIN"));
		System.out.println(newPalindrome("MADAM"));

		System.out.println(count7(712777737));
	}
	public static void printHelloWorld(int n){

		if(n == 0){
			return ;
		}

		System.out.println("Hello World");
		printHelloWorld(n - 1);
	}

	//5 raise 2
	public static int baseExp(int b , int e){
		if(e == 0){
			return 1;
		}

		return b * baseExp(b,--e);
	}

//5 = 5 * 4 * 3 * 2 = 120
	public static int factorial(int no){

		if(no == 0){
			return 1;
		}

		return no * factorial( no - 1);
	}

	//

	public static int mysteryNumber(int n){

		if(n < 10){
			return n;
		}

		int a = n / 10;
		int b = n % 10;

		return mysteryNumber(a + b);
	}



	//      8 4 2 1
	//5 - > 0 1 0 1
	public int binaryNumber(int no){

		return -1;
	}

	public static boolean isPalindrome(String str){

			return isPalindromeRec(str,0,str.length() - 1);
	}

	public static boolean isPalindromeRec(String str , int start , int end){

		if(start == end){
			return true;
		}

		if(str.charAt(start) == str.charAt(end)){
			return isPalindromeRec(str,++start,--end);
		}

		return false;

	}

	public static boolean newPalindrome(String str){
		int size = str.length();

		if(size == 0 || size == 1){
			return true;
		}

		if(str.charAt(0) != str.charAt(size - 1)){
			return false;
		} else {
			return newPalindrome(str.substring(1,size - 1));//get rid of first and last
		}
	}
	//77567
	public static int count7(int no ){

		if(no <= 0){
			return 0;
		}

		if(no % 10 == 7){
			return 1 + count7(no/10);
		}

		return count7(no/10);
	}


}
