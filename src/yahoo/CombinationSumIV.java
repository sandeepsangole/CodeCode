
package yahoo;
/* 
40. Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

*/


import java.util.*;

class CombinationSumIV {


	public static void main(String[] args) {

		CombinationSumIV obj = new CombinationSumIV();
		//List<List<Integer>> res = new ArrayList<>();
		//res = obj.combinationSum4(new int[]{1,2,3},4);
		//res.stream().forEach(System.out::println);
		System.out.println(obj.combinationSum4(new int[] { 1, 2, 3 }, 4));

	}

	public int combinationSum4(int[] nums, int target) {
		int[] comb = new int[ target + 1 ];
		comb[ 0 ] = 1;
		for (int i = 1; i < comb.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i - nums[ j ] >= 0) {
					comb[ i ] += comb[ i - nums[ j ] ];
				}
			}
		}
		return comb[ target ];
	}


}