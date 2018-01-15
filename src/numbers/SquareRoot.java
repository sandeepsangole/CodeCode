package numbers;

public class SquareRoot {

	public static void main(String[] args) {

		System.out.println(squareRoot(10));
	}

	public static int squareRoot(int n){
		if(n == 0){
			return 0;
		}

		int left = 1;
		int right = n;
		int sqrt = 0;
		while (left <= right){
			int mid = (left + right) / 2;
			if(mid * mid <= n){
				left = mid + 1;
				sqrt = mid;
			} else {
				right = mid - 1;
			}
		}

		return sqrt;
	}
}
