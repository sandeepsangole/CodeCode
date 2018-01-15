package array;

public class AddDigits {

	public static void main(String[] args) {
		System.out.println(addDigits(111));
	}

	public static int addDigits(int num) {
		if(num < 10){
			return num;
		}

		int n1 = num % 10;
		int n2 = num /10;

		return addDigits(n1 + n2);
	}
}
