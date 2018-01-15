package dp.matrix.dp;

/*
Given two strings, find the longest common subsequence (LCS).

Your code should return the length of LCS.'

For "ABCD" and "EACB", the LCS is "AC", return 2.

 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {

		/*
		1. 2d cache
		2. if i == j then diagonal + 1
		   else
		   max(top,left)
		 3. Keep track of max
		 4. return max

		 */

		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		obj.longestCommonSubsequence("ABCDEFG","EACBGF");

	}

	public void longestCommonSubsequence(String str1 , String str2){

		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();

		System.out.println(longestCommonSubsequenceMatrix(charArray1, charArray2));
	}

	public int longestCommonSubsequenceMatrix(char[] arr1 , char[] arr2){

		if(arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0){
			return 0;
		}

		int[][] cache = new int[arr1.length + 1][ arr2.length + 1];
		int max = Integer.MIN_VALUE;
		for(int i = 1;i<=arr1.length;i++){
			for(int j = 1;j<=arr2.length;j++){

				if(arr1[i - 1] == arr2[j - 1]){
					cache[i][j] = 1 + cache[i-1] [j-1];
				} else {
					cache[i][j] = Math.max(cache[i - 1][j],cache[i][j - 1]);
				}

				max = Math.max(max , cache[i][j]);
			}
		}

		for(int i = 0;i<=arr1.length;i++){
			for(int j = 0;j<=arr2.length;j++){
				System.out.print(cache[i][j] +" ");
			}
			System.out.println();
		}

		return max;
	}


}
