package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

90. Subsets II

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */
public class SubsetsII {

	public static void main(String[] args) {
		int[] arr = {2,1,2};
		SubsetsII obj = new SubsetsII();
		obj.subSets(arr);
	}

	public List<List<Integer>> subSets(int[] arr){

		List<List<Integer>> res = new ArrayList<>();

		if(arr == null || arr.length == 0){
			return res;
		}

		Arrays.sort(arr);

		subSetsUtil(arr , 0 , new ArrayList<>(),res);

		res.stream().forEach(System.out::println);

		return res;

	}

	public void subSetsUtil(int[] arr , int start , List<Integer> subLst , List<List<Integer>> res){

		res.add(new ArrayList<>(subLst));

		for(int i = start ;i<arr.length;i++){

			if(i > start && arr[i] == arr[i-1]) continue;

			subLst.add(arr[i]);
			subSetsUtil(arr , i + 1 , subLst,res);
			subLst.remove(subLst.size() - 1);
		}
	}
}
