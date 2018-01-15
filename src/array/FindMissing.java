package array;

public class FindMissing {
	public static void main(String[] args) {

		int[] arr1 = {9,7,8,5,4,6,2,3,1};
		int[] arr2=  {2,4,3,9,1,8,5,6};
		System.out.println(findMissing(arr1, arr2));
	}

	public static int findMissing(int[] arr1 , int[] arr2){
		int res = arr1[0];
		for (int i = 1;i<arr1.length;i++){
			res ^= arr1[i];
		}

		for (int j =0;j<arr2.length;j++){
			res ^= arr2[j];
		}

		return res;
	}
}
