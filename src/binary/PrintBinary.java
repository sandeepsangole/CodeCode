package binary;

public class PrintBinary {
	public static void main(String[] args) {
		printBinaryRec(2,"");
	}


	public static void printBinaryRec(int n , String pre) {

		if (n == 0) {
			System.out.println(pre);
		} else {
			for (int i = 1; i <= 6; i++) {
				printBinaryRec(n - 1, pre + i);

			}
		}
	}
}
