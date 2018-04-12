package strings;

/*

394. Decode String

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is
being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed,
etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only
for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".


stack1 stack2
3       a
2       bc

3[a2[c]]
stack1 stack2
3       a
        cc

 */

import java.util.*;

public class DecodeString {

	public static void main(String[] args) {
		String       str = "[]";
		DecodeString obj = new DecodeString();
		System.out.println(obj.decodeString(str));
	}

	public String decodeString(String s) {

		Stack<Integer> stack1  = new Stack<>();
		Stack<String>  stack2  = new Stack<>();
		StringBuilder  tempStr = new StringBuilder();
		int            i      = 0;
	while(i < s.length()) {

			char c = s.charAt(i);

			if (Character.isDigit(c)) {
				int no = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					no = no * 10 + Character.getNumericValue(c);;
					i++;
				}

				stack1.push(no);

			} else if (c == '[') {
				stack2.push(tempStr.toString());
				tempStr.setLength(0);
				i++;
			} else if (Character.isLetter(c)) {

				while (i < s.length() && Character.isLetter(s.charAt(i))) {
					tempStr.append(c);
					i++;
				}
				i--;
				stack2.push(tempStr.toString());
				tempStr.setLength(0);
			} else if (c == ']') {
				int    count = !stack1.isEmpty() ? stack1.pop() : 0;
				String str   = !stack2.isEmpty() ? stack2.pop() : "";
				while (count > 0) {
					tempStr.append(str);
					count--;
				}
				stack2.push(tempStr.toString());
			}
		}

		return !stack2.isEmpty() ? stack2.pop() : "";

	}


}
