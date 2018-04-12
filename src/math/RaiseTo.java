package math;

public class RaiseTo {

	public static void main(String[] args) {
		System.out.println(raiseTo(2,3));
	}

	public static int raiseTo(int base , int raise){

		return base << (raise - 1);
	}
}
