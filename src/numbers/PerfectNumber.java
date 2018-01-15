package numbers;

public class PerfectNumber {

	public static void main(String[] args) {
		System.out.println(Math.sqrt(28));
		System.out.println(checkPerfectNumber(28));
	}

	public static boolean checkPerfectNumber(int num) {

		if(num == 1) return false;

		//28 - 1 2(14) 4(7)

		int sum = 0;
		for(int i = 2 ; i<= Math.sqrt(num);i++){
			if(num % i == 0){
				sum+=i;
				sum+=num/i;
			}
		}
		sum++;
		System.out.println(sum);
		return sum == num;
	}

}
