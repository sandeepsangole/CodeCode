package numbers;

import java.util.Arrays;

public class ArrangeCoins {

	public static void main(String[] args) {
	//	System.out.println(arrangeCoins(8));
		//System.out.println(Arrays.toString(plusOne(new int[]{1,2,9})));

		System.out.println(guessNumber(10));
	}

	public static int arrangeCoins(int n) {
		int row = 1;
		int count = 0;
		//n = 8
		while(row <= n ){
			count++;
			n-=row;
			row++;
		}

		return count;
	}

	public static int[] plusOne(int[] digits) {

		int n = digits.length;
		for(int i=n-1; i>=0; i--) {
			if(digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
		}

		int[] newNumber = new int [n+1];
		newNumber[0] = 1;

		return newNumber;
	}

	public static int guessNumber(int n) {

		int low = 1;
		int high = n;
		int no = 6;
		while(low <= high)  {

			int mid = (low + high) / 2;
			if(no == 0){
				return mid;
			} else if(no < 0){
				high = mid - 1;
			} else if(no > 0){
				low = mid + 1;
			}

		}

		return -1;
	}
}
