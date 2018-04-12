package pramp;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */


/*

I, II, III, IV, V
a  b   c   d    e

adb => IIVII

IVI => aea, da

a => I
b => II
c => III

eg : bca
     IIIIII

*/

class Yahoo {

	public static void main(String[] args) {
		Yahoo obj = new Yahoo();
		try {


			System.out.println(obj.stringToRoman("bca"));
			System.out.println(obj.stringToRoman("eda"));
			// System.out.println(obj.stringToRoman("$%%a"));
			System.out.println(obj.romanToString("III"));


		} catch(Exception e){
			System.out.println("Invalid Letter  ");
		}

	}

	public List<String> stringCombinations(String input){

		List<String> res = new ArrayList<>();

		if(input == null || input.length() == 0){
			return res;
		}

		StringBuilder sb = new StringBuilder();
		stringCombinationsUtil(input, res, 0 , sb);

		return res;
	}

	public void stringCombinationsUtil(String input, List<String> res , int start,
	                                   StringBuilder sb){

		for(int i = start ; i < input.length();i++){

			sb.append(input.charAt(i));
			res.add(sb.toString());
			stringCombinationsUtil(input,res,i + 1, sb);
			sb.setLength(sb.length() - 1);
		}
	}


	public String romanToString(String input){

		int MAX_LEN = 3;
		if(input == null || input.length() == 0){
			return input;
		}

		Map<String , Character> map = new HashMap<>();
		map.put("I",'a');
		map.put("II",'b');
		map.put("III",'c');
		map.put("IV",'d');
		map.put("V",'e');

		StringBuilder res = new StringBuilder();

		List<String> comb =  stringCombinations(input);
		System.out.println(comb);

		for(String str : comb){

			res.append(map.get(str));
		}

		return res.toString();

	}

	public String stringToRoman(String input)  throws Exception {

		if(input == null || input.length() == 0){
			return input;
		}

		Map<Character , String> map = new HashMap<>();
		map.put('a',"I");
		map.put('b',"II");
		map.put('c',"III");
		map.put('d',"IV");
		map.put('e',"V");

		StringBuilder res = new StringBuilder();

		for(char c : input.toCharArray()){

			if(map.containsKey(c)){
				res.append(map.get(c));
			} else {
				throw new Exception("Invalid Character");
			}
		}

		return res.toString();
	}
}


