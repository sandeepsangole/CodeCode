package strings;

/*

32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.



 */

import java.util.*;

public class ValidParenthesisII {
	public static void main(String[] args) {
		ValidParenthesisII obj = new ValidParenthesisII();
		//System.out.println(obj.lengthOfValidParenthesis("()(()"));
		System.out.println(obj.lengthOfValidParenthesis("))()(("));
	}

	/*

	insert -1 into stack - length is zero
	if opening insert into stack
	else pop and find length
	if stack is empy insert

	return max



	( )  ( ( )
	0 1  2 3 4
	 */
	public int lengthOfValidParenthesis(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		//Stack store the index to find max length

		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int max = 0;

		for(int i = 0;i< s.length();i++){

			if(s.charAt(i) == '('){
				stack.push(i);
			} else {
				stack.pop();

				if(stack.isEmpty()){
					stack.push(i);
				} else {
					max = Math.max(max , i - stack.peek());
				}

			}
		}

		return max;
	}
	
	
}
