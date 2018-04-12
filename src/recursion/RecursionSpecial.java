package recursion;

public class RecursionSpecial {


	public static void main(String args[]) {

		RecursionSpecial obj = new RecursionSpecial();
		System.out.println(obj.isPalindrome("sanast"));
		System.out.println(obj.countTh("theththaaatgghthss"));
		System.out.println(obj.moveX("monxeyxgame"));
		System.out.println(obj.moveEmptySpaces("    Sa an deep"));
		System.out.println(obj.reverseStringUtil("Sandeep"));
		System.out.println(obj.reverseStringUtilII("Sandeep"));
		System.out.println(obj.wordReverse("cat is running"));
		System.out.println("digitOccurance :" + obj.digitOccurance(82818, 8));
		System.out.println("sumNaturalNumbers :" + obj.sumNaturalNumbers(3));
		System.out.println(obj.mutliply(2, 3));
		System.out.println(obj.findElementBinarySearch(new int[] { 1, 3, 5, 7, 9, 11, 15, 16, 50, 100 }, 5));

			//System.out.println(obj.countTimes10(new int[] { 1, 5, 6, 160, 8, 80, 90, 90 }, 0));


	}
	
	
	public boolean isPalindrome(String str){
		if(str.length() <= 1){
			return true;
		}

		if(str.charAt(0) != str.charAt(str.length() -1)){
			return false;
		}

		return isPalindrome(str.substring(1,str.length() -1));
	}

	public int findElementBinarySearch(int[] arr, int target) {

		if (arr == null || arr.length == 0) {
			return -1;
		}

		return findElementBinarySearch(arr , 0 , arr.length - 1 ,target);

	}

	private int findElementBinarySearch(int[] arr, int start, int end, int target) {

		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;

		if(arr[mid] == target){
			return mid;
		}

		if(target > arr[mid]){
			return findElementBinarySearch(arr, mid + 1, end, target);
		} else {
			return findElementBinarySearch(arr,start,mid - 1,target);
		}


	}



	 // 2 + ( 2,2 )
	// 2 + ( 2 ,1 = 4
	// 2 +   (2 , 0) = 2

	
	
	public int mutliply(int x , int y){

		if(x == 0) return 0;
		if(x == 1) return y;

		return y + mutliply(--x,y);

	}

	public int sumNaturalNumbers(int n){

		if(n == 0){
			return 0;
		}

		return n + sumNaturalNumbers(n - 1);

	}

	
	public int digitOccurance(int digit , int occurance){

		if(digit == 0){
			return 0;
		}

		if(digit % 10 == occurance){
			return 1 + digitOccurance(digit/10 , occurance);
		}

		return digitOccurance(digit/10,occurance);
	}
	
	
	
	public String wordReverse(String str){

		int idx = str.indexOf(" ");

		if(idx <= 0){
			return str;
		}

		return wordReverse(str.substring(idx + 1)) +" "+ wordReverse(str.substring(0,idx));
	}

	
	
	public String reverseStringUtil(String str){

		if(str.length() < 2){
			return str;
		}

		return reverseStringUtil(str.substring(1)) + str.charAt(0);
	}

	public String reverseStringUtilII(String str){

		if(str.length() < 2){
			return str;
		}

		String left = reverseStringUtil(str.substring(0, str.length() / 2));
		String right = reverseStringUtilII(str.substring(str.length()/2));

		return right + left;
	}

	public String moveEmptySpaces(String str){

		if(str.length() < 1) return "";

		if(str.charAt(0) ==' '){
			return moveEmptySpaces(str.substring(1)) + str.charAt(0);
		}

		return str.charAt(0) + moveEmptySpaces(str.substring(1));

	}

		public String moveX(String str){

			if(str.length() < 1){
				return "";
			}

			if(str.charAt(0) == 'x'){
				return moveX(str.substring(1)) + str.charAt(0);
			}

			return str.charAt(0) + moveX(str.substring(1));
		}

		public int countTh(String str){

			if(str.length() < 2)
				return 0;

			if(str.substring(0,2).endsWith("th")){
				return 1 + countTh(str.substring(2));
			}

			return countTh(str.substring(1));
		}

}
