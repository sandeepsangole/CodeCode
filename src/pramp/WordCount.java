package pramp;

/*
Word Count Engine
Implement a document scanning function wordCountEngine, which receives a string document and
returns a list of all unique words in it and their number of occurrences, sorted by the number of occurrences
in a descending order. If two or more words have the same count, they should be sorted alphabetically
 (in an ascending order). Assume that all letters are in english alphabet.
  You function should be case-insensitive, so for instance, the words “Perfect” and “perfect” should be considered the same word.

The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.

Analyze the time and space complexities of your solution. Try to optimize for time while keeping a polynomial space complexity.


input:  document = "get get Practice makes get perfect. you'll only
                    get Perfect by practice. just practice!"

output: [ ["practice", "3"], ["perfect", "2"],
          ["by", "1"], ["get", "1"], ["just", "1"],
          ["makes", "1"], ["only", "1"], ["youll", "1"]  ]

 */

import java.util.*;
import java.util.Map.Entry;
public class WordCount {

	public static void main(String[] args) {
		String document ="\"Every book is a quotation; and every house is a quotation out of all forests, and mines, and stone quarries; and every man is a quotation from all his ancestors. \"";
		String[][] res = wordCountEngine(document);
		for(String[] s : res ){
			System.out.println(Arrays.toString(s));
		}
	}

	static String[][] wordCountEngine(String document) {
		/*
			1. Split document by space ,
			2. convert to lower case and remove special chars
			3. Build Map with count and then sort by value in desc
		*/


		String[] input = document.split(" ");
		Map<String,Integer> map = new LinkedHashMap<>();
		for(String str : input){
			str = str.toLowerCase().replaceAll("[^a-z]","");
			if(str.length() == 0) continue;
			if(map.containsKey(str)){
				map.put(str , map.get(str) + 1);
			} else {
				map.put(str,1);
			}
		}


		List<Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list , (Entry<String,Integer> o1 , Entry<String,Integer> o2)->
				{
					int com = o2.getValue() - o1.getValue();
					if(com != 0){
						return com;
					} else {
						return o1.getKey().compareTo(o2.getKey());
					}
				}
		);


		//Sort Map by Value
		/*List<Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, (Entry<String,Integer> o1 , Entry<String,Integer> o2) -> o2.getValue() - o1.getValue());
*/
		String[][] res = new String[list.size()][];

		for(int i = 0;i <list.size();i++){
			res[i] =new String[]{list.get(i).getKey(),list.get(i).getValue().toString()};
		}

		return res;
	}

}
