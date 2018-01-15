package binary;

public class NumberOfOnes {

	public static void main(String[] args) {

		System.out.println(countOnesInBinary(10));
	}

	public static int countOnesInBinary(int n){

		int count = 0;
		while (n > 0){
			n = n & (n-1);
			count++;
		}

		return count;
	}
}
