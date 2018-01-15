package strings;

import java.util.*;

/*
20. Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.



 */

public class ValidParenthesis {
	public static void main(String[] args) {
		ValidParenthesis obj = new ValidParenthesis();
		System.out.println(obj.isValidParenthesis("()[]{}"));
		System.out.println(obj.isValidParenthesis("([)]"));
	}

	public boolean isValidParenthesis(String input){

		Map<Character,Character> map = new HashMap<>();
		map.put('(',')');
		map.put('{','}');
		map.put('[',']');

		Stack<Character> stack = new Stack<>();
		for (char c : input.toCharArray()){

			if(map.containsKey(c)){
				stack.push(c);
			} else if(map.values().contains(c)){
					if(!stack.isEmpty() && map.get(stack.peek()) == c){
							stack.pop();
					}
			}


		}

		return stack.isEmpty();
	}
}
