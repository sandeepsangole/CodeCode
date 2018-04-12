package Permutations;

/*

39. Combination Sum

Given a set of candidate numbers (C) (without duplicates) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]

 */

import java.util.*;

public class CombinationSum {

	public static void main(String[] args) {

		CombinationSum obj = new CombinationSum();
		int[]          arr = { 2, 3, 6, 7, 5 };
		obj.combinationSum(arr, 7);
	}


	public List<List<Integer>> combinationSum(int[] arr, int target) {

		List<List<Integer>> res = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return res;
		}
		List<Integer> subLst = new ArrayList<>();

		Arrays.sort(arr);
		combinationSumUtil(arr, 0, target, subLst, res);

		res.stream().forEach(System.out::println);

		return res;

	}

	public void combinationSumUtil(int[] arr, int start, int target, List<Integer> subLst, List<List<Integer>> res) {


		if (target == 0) {
			res.add(new ArrayList<>(subLst));
		} else {
			for (int i = start; i < arr.length; i++) {
				if(target - arr[ i ] >= 0) {
					subLst.add(arr[ i ]);
					combinationSumUtil(arr, i, target - arr[ i ], subLst, res);
					subLst.remove(subLst.size() - 1);
				}

			}
		}
	}
}
