package strings;

import java.util.*;

public class CombinationStrings {

	
	public List<String> combinations(String str){
		List<String> res = new ArrayList<>();
		if(str == null || str.length() == 0){
			return res;
		}
		
		StringBuilder sb = new StringBuilder();
		combinationsRec(sb,str,res,0);
		
		return res;
		
	}
	
	public void combinationsRec(StringBuilder sb , String str , List<String> res, int index){
		
		if(sb.length() > 0 && isPalindrome(sb.toString(), 0 , sb.length() - 1)){
			res.add(sb.toString());
		}
		for(int i = index;i<str.length();i++){
			sb.append(str.charAt(i));
			combinationsRec(sb,str,res,i + 1);
			sb.setLength(sb.length() - 1);
			
		}
	}
	
	public boolean isPalindrome(String str , int start , int end){
		if(start > end){
			return false;
		}
		
		while (start < end){
		
			if(str.charAt(start++) != str.charAt(end--)){
				return false;
			} 
			
		}   
		
		return true;
	}
	
	public static void main(String[] args) {
		CombinationStrings obj = new CombinationStrings();
		System.out.println(obj.combinations("aaa"));
	}
}
