package strings;

import java.util.Arrays;

public class ReverseStringII {

	public static void main(String[] args) {

		ReverseStringII obj = new ReverseStringII();
		System.out.println(obj.reverseStr("abcd",2));

	}

	public String reverseStr(String s, int k) {

		if(s == null || s.length() == 0){
			return s;
		}

		char[] sarray = s.toCharArray();
		int i = 0;
		for(i = 0;i<sarray.length - k;){
			if(i+k < sarray.length) {
				swap(sarray,i,i+k-1);
			}

			i = i + (2 * k);
		}

		if((sarray.length - 1 - i) <= k - 1){
			swap(sarray,i,sarray.length - 1);
		}

		return String.valueOf(sarray);
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
