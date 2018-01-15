package pramp;

import java.util.Arrays;

/*

Sentence Reverse
You are given an array of characters arr that consists of sequences of characters separated by space characters.
Each space-delimited sequence of characters defines a word.

Implement a function reverseWords that reverses the order of the words in the array in the most efficient manner.

Explain your solution and analyze its time and space complexities.

input:  arr = [ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ',
                'm', 'a', 'k', 'e', 's', '  ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]

output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ',
          'm', 'a', 'k', 'e', 's', '  ',
          'p', 'e', 'r', 'f', 'e', 'c', 't' ]

 */
public class ReverseSentense {

	public static void main(String[] args) {
		char[] arr = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ','m', 'a', 'k', 'e', 's', ' ','p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
		reverseWords(arr);

	}

	static char[] reverseWords(char[] arr) {

		if(arr == null || arr.length == 0){
			return arr;
		}

		swap(arr,0,arr.length - 1);

		int start = 0;
		for(int i =0;i< arr.length;i++){

			if (arr[i] ==' '){
				swap(arr , start,i - 1);
				start = i + 1 ;
			}
		}

		swap(arr,start,arr.length - 1);

		return arr;
	}

	public static void swap(char[] arr , int index1, int index2){

		while (index1 < index2) {
			char tmp = arr[ index1 ];
			arr[ index1 ] = arr[ index2 ];
			arr[ index2 ] = tmp;
			index1++;
			index2--;
		}

	}

}
