package strings;

import java.util.*;

public class SimplifyPath {
	public static void main(String[] args) {
		SimplifyPath obj = new SimplifyPath();
		System.out.println(obj.simplifyPath("/"));
	}

	public String simplifyPath(String path) {

		StringBuilder res = new StringBuilder();
		res.append("/");

		Stack<String> stack = new Stack<>();
		String[] pathStrings = path.split("/");
		for(String s : pathStrings){
			if(" ".equals(s) || s.equals(".") || s.length() == 0){
				continue;
			} else if("..".equals(s)){
				if(!stack.isEmpty()){
					stack.pop();
				}
			} else {stack.push(s);
			}
		}

		while(!stack.isEmpty()){

			res.append(stack.pop());
			if(!stack.isEmpty()){
				res.append("/");
			}

		}

		return res.toString();
	}

}
