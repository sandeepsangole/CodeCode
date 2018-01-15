package stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack extends Stack<Integer> {
	Stack<Integer> mainStack = null;
	Stack<Integer> minStack = null;

	MinStack() {
		mainStack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int ele) {

		mainStack.push(ele);

		if(minStack.isEmpty() || minStack.peek() > ele){
			minStack.push(ele);
		}
	}

	public Integer pop() throws EmptyStackException {
		if(isEmpty()){
			throw new EmptyStackException();
		}

		int tmp =  mainStack.pop();
		if(tmp == minStack.peek()){
			minStack.pop();
		}
		return tmp;
	}

	public int size() {
		if(isEmpty()){
			throw new EmptyStackException();
		}

		return mainStack.size();
	}

	public boolean isEmpty(){
		return mainStack.isEmpty();
	}

	public int min(){
		if(minStack.isEmpty()) {
			throw new EmptyStackException();
		}
			return minStack.peek();
	}

}
