package dp.matrix.dp;

/*
72. Edit Distance

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
(each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

 */
public class MinEditDistance {
	public static void main(String[] args) {

		MinEditDistance obj = new MinEditDistance();
		System.out.println(obj.minEditDistance("kitten","sitting"));
	}

	public int minEditDistance(String s1, String s2){
		int[][] cache = new int[s1.length() + 1][s2.length() + 1];

		for(int i = 0;i<= s1.length();i++){

			for(int j = 0;j<= s2.length();j++){

				if(i == 0){ // first row
					cache[i][j] = j;
				} else if(j == 0){ // first col
					cache[i][j] = i;
				} else if(s1.charAt(i - 1) == s2.charAt( j -1)){ // if same - diagonal
					cache[i][i] = cache[i -1][j - 1];
				} else {
					cache[i][j] = 1 + Math.min(Math.min(cache[i- 1][j],cache[i][j -1]), cache[i-1][j-1]);
				}
					/*
						f(i, j - 1) represents insert operation
						f(i - 1, j) represents delete operation
						f(i - 1, j - 1) represents replace operation
					 */
			}
		}

		return cache[s1.length()][s2.length()];
	}
}
