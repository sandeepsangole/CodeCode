package cracking.coding.arraystring;


import java.util.*;

public class PalindromePermutation {

	public static void main(String[] args){
		PalindromePermutation obj = new PalindromePermutation();
		System.out.println(obj.isPalindromePermutation("Tact Coa"));
	}

	public boolean isPalindromePermutation(String str){

		int count = 0;
		if(str != null && str.length() == 0) return false;
		Map<Character , Integer> map = new HashMap<Character,Integer>();
		char[] arr =  str.toLowerCase().toCharArray();
		for(char c : arr){
			if(c ==' ') continue;

			if(map.containsKey(c)){

				map.put(c, map.get(c) + 1);
			} else {

				map.put(c,1);
			}
		}

		map.keySet().forEach(key -> System.out.println(key + "->" + map.get(key)));

		for(int i :map.values()){
			//System.out.println( "-"+i);
			if(i%2 != 0){
				count++;
			}
			if(count > 1){
				return false;
			}
		}

		return true;


	}

}
