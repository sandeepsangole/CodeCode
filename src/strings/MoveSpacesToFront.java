package strings;

import java.util.Arrays;

public class MoveSpacesToFront {

	public static void main(String[] args) {
		String str = "Sa  n de p";
		MoveSpacesToFront obj = new MoveSpacesToFront();
		String res = obj.moveSpaces(str);
		System.out.println(res);


	}

	public String moveSpaces(String str){

		char[] arr = str.toCharArray();
		int end = arr.length - 1;
		for(int i = end ; i>=0;i--){

			if(arr[i] !=' '){
				swap(arr , i , end--);
			}

		}
		return Arrays.toString(arr);
	}

	public void swap(char[] arr , int i , int j){
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
