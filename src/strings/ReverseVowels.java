package strings;

public class ReverseVowels {
	public static void main(String[] args) {
		ReverseVowels obj = new ReverseVowels();
		System.out.println(obj.reverseVowels("hello"));
	}

	public String reverseVowels(String s) {
		if(s == null || s.length() == 0){
			return s;
		}

		char[] arr = s.toCharArray();
		swap(arr , 0, arr.length - 1);
		return String.valueOf(arr);
	}

	public void swap(char[] arr,int index1 , int index2){

		while(index1 < index2){
			if(isVowel(arr[index1]) && isVowel(arr[index2])) {
				char tmp = arr[ index1 ];
				arr[ index1 ] = arr[ index2 ];
				arr[ index2 ] = tmp;

				index1++;
				index2--;

			} else if(!isVowel(arr[index1])){
				index1++;
			} else if(!isVowel(arr[index2])){
				index2--;
			} else {
				index1++;
				index2--;
			}

		}
	}

	public boolean isVowel(char ch){

		if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
		{
			return true;
		}
		return false;
	}

}
