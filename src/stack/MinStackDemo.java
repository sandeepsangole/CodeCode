package stack;

public class MinStackDemo {

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		/*obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.push(1);
		obj.push(6);
*/
		System.out.println(obj.min());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.min());
		//System.out.println(obj.pop());
		//System.out.println(obj.size());

	}

}
