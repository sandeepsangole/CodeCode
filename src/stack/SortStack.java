package stack;

import java.util.*;

public class SortStack {
	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(3);
		stack.push(8);


		Stack<Integer> tmp =  reverseStack(stack);

		while (!tmp.isEmpty()){
			System.out.print(tmp.pop() +" ");
		}
	}

	public static Stack<Integer> reverseStack(Stack<Integer> stack){

		Stack<Integer> tmpStack = new Stack<>();

		while (!stack.isEmpty()){

			int tmp = stack.pop();

			while (!tmpStack.isEmpty() && tmpStack.peek() < tmp){
				stack.push(tmpStack.pop());
			}

			tmpStack.push(tmp);
		}

		return tmpStack;
	}

}
