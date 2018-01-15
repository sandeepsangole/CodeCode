package strings;

public class ATOI {

	public static void main(String[] args) {
		ATOI obj = new ATOI();
		atoi("123");
		atoi("  12 33  ");
		atoi("  12 33?  ");
		atoi(" #$%12_+33  ");
	}

	public static int atoi(String str){

		System.out.println(str.replaceAll("[^0-9]",""));
		return -1;
	}
}
