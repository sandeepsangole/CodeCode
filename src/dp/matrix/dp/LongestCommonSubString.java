package dp.matrix.dp;

public class LongestCommonSubString {

	public static void main(String args[]){
		LongestCommonSubString lcs = new LongestCommonSubString();
		char str1[] = "sansdy".toCharArray();
		char str2[] = "and".toCharArray();
		System.out.println(lcs.longestCommonSubstring(str1, str2));
		System.out.println(lcs.longestCommonSubstringRec(str1, str2,0,0));
	}

	public int longestCommonSubstring(char[] str1 , char[] str2){

		int maxCommonStr = Integer.MIN_VALUE;

		int[][] cache = new int[str1.length + 1][str2.length + 1];

		for (int i = 1 ;i<= str1.length;i++){
			for(int j = 1;j <= str2.length;j++){
				if(str1[i - 1] == str2[j - 1]) {
					cache[ i ][ j ] = 1 + cache[i - 1][j - 1];
					if(maxCommonStr < cache[i][j]){
						maxCommonStr = cache[i][j];
					}
				}

			}
		}

		return maxCommonStr;
	}

	public  int longestCommonSubstringRec(char[] str1 , char[] str2, int str1Index , int str2Index){

		if(str1Index >= str1.length || str2Index >= str2.length){
			return 0;
		}

		if(str1[str1Index] == str2[str2Index]){
			return 1 + longestCommonSubstringRec(str1,str2,str1Index + 1,str2Index + 1);
		} else {
			return Math.max(longestCommonSubstringRec(str1,str2,str1Index + 1,str2Index) ,
					longestCommonSubstringRec(str1,str2,str1Index,str2Index + 1));
		}

	}

}
