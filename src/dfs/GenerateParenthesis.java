package dfs;

import java.util.*;

public class GenerateParenthesis {
	public static void main(String[] args) {

		GenerateParenthesis obj = new GenerateParenthesis();
		obj.generateParenthesis(3);
	}

	public void generateParenthesis(int n){

		List<String> res = new ArrayList<>();
		generateParenthesis("",n,n,res);
		res.stream().forEach(System.out::println);
	}

	public void generateParenthesis(String str , int left , int right, List<String> res){

		if(left > right){
			return;
		}

		if(left == 0 && right == 0){
			res.add(str);
		} else{

			if(left > 0){
				generateParenthesis(str+"(" , left - 1,right,res);
			}

			if(right > 0){
				generateParenthesis(str+")",left,right - 1,res);
			}

		}
	}
}
