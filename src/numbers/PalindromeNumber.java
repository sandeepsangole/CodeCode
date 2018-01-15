package numbers;

public class PalindromeNumber {

	public static void main(String[] args) {

		System.out.println(isPalindromeNo(10));
		System.out.println();
		//System.out.println(isPalindromeNo(1221));

	}

	public static boolean isPalindromeNo(int num){

		if(num < 0 || (num %10 == 0 && num != 0)){
			return false;
		}

		int revertedNo = 0;
		while (num > revertedNo){
			revertedNo = revertedNo * 10 + num%10;
			num/=10;
		}

		return num == revertedNo || revertedNo/10 == num;


	}
}
