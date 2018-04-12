package strings;

import java.util.*;

public class Anagram {

	public static void main(String[] args) {
		Anagram obj = new Anagram();
		System.out.println(obj.anagrams("abc"));
	}

	public List<String> anagrams(String str) {

		List<String> res = new ArrayList<>();
		findAnagrams("", str, res);
		return res;
	}

	public void findAllPermutations(String pre, String str, List<String> res) {
		/*

			"" , str, res
			a   bc res
			ab c res
			abc "" res

			a  bc res

			ac b res

			acb res

		 */
		if (str.length() == 0) {
			res.add(pre);
		} else {
			for (int i = 0; i < str.length(); i++) {

				if (str.indexOf(str.charAt(i), i + 1) == 0) continue;

				findAnagrams(pre + str.charAt(i), str.substring(0, i) + str.substring(i), res);

			}
		}
	}

	public void findAnagrams(String pre, String str, List<String> res) {

		if (str.length() == 0) {
			res.add(pre);
		} else {

			for (int i = 0; i < str.length(); i++) {
				if (str.indexOf(str.charAt(i), i + 1) != -1)
					continue;
				findAnagrams(pre + str.charAt(i), str.substring(0, i) + str.substring(i + 1), res);
			}
		}


	}
	
	
}
