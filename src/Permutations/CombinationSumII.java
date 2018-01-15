package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

40. Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C
where the candidate numbers sums to T.

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
public class CombinationSumII {

	public static void main(String[] args) {

		CombinationSumII obj = new CombinationSumII();
		int[] arr = {10, 1, 2, 7, 6, 1, 5};
		obj.combinationSum(arr , 8);
	}

	public List<List<Integer>> combinationSum(int[] arr , int target) {

		List<List<Integer>> res = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return res;
		}

		List<Integer> subLst = new ArrayList<>();
		Arrays.sort(arr);
		combinationSumUtil(arr , target, subLst, res, 0);
		res.stream().forEach(System.out::println);

		return res;
	}

	public void combinationSumUtil(int[] arr , int target , List<Integer> subLst , List<List<Integer>> res, int start){

		if(target < 0) return;
		if(target == 0) {
			res.add(new ArrayList<>(subLst));
		} else {

			for(int i = start ; i<arr.length;i++) {

					if(i > start && arr[i] == arr[i-1]) continue;

					subLst.add(arr[i]);
					combinationSumUtil(arr, target - arr[i] , subLst, res,i + 1);
					subLst.remove(subLst.size() - 1);

			}
		}
	}

}
