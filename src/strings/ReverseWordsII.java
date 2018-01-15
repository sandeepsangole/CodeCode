package strings;

/*
557. Reverse Words in a String III
Given a string, you need to reverse the order of characters in each word within a sentence
while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordsII {

	public static void main(String[] args) {
		ReverseWordsII obj = new ReverseWordsII();

		String res = obj.reverseWords("Let's take LeetCode contest");
		System.out.println(res);
	}
	public String reverseWords(String s) {
		if(s == null || s.length() == 0){
			return s;
		}

		char[] carray = s.toCharArray();
		int start  = 0;
		for(int i = 0;i <carray.length;i++){

			if(carray[i]==' '){
				swap(carray , start , i - 1);
				start = i + 1;
			}
		}

		swap(carray , start , carray.length - 1);

		return String.valueOf(carray);
	}

	public void swap(char[] arr , int index1 , int index2) {

		while (index1 < index2) {
			char tmp = arr[ index1 ];
			arr[ index1 ] = arr[ index2 ];
			arr[ index2 ] = tmp;
			index1++;
			index2--;
		}

	}
}
