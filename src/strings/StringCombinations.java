package strings;

import java.util.*;

public class StringCombinations {

	public static void main(String[] args) {
		StringCombinations obj = new StringCombinations();
		obj.combinations("wxyz");
	}
	//wxyz
	//w wx wy 
	private List<String> combinations(String str){
		List<String> res = new ArrayList<>();
		combinationsUtil(str , res , new StringBuilder() , 0);
		System.out.printf(res.toString());
		
		return res;
	}

	private void combinationsUtil(String str , List<String> res , StringBuilder temp , int start){
		
		if(temp.length() > 0){
			res.add(temp.toString());
		}
		
		for (int i = start;i < str.length();i++){
			temp.append(str.charAt(i));
			combinationsUtil(str,res,temp , i + 1);
			temp.setLength(temp.length() - 1);
				
		}

	}
	
}
