package Permutations;

/*
78 Subsets

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 */

import java.util.*;

public class Subsets {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		Subsets obj = new Subsets();
		obj.subSets(arr);
	}

	public List<List<Integer>> subSets(int[] arr){
		List<List<Integer>> res = new ArrayList<>();
		if(arr == null || arr.length == 0){
			return res;
		}

		subSetsUtil(arr , 0 , new ArrayList<>(),res);

		res.stream().forEach(System.out::println);

		return res;

	}

	public void subSetsUtil(int[] arr , int index , List<Integer> subLst , List<List<Integer>> res){

		res.add(new ArrayList<>(subLst));

		for(int i = index;i<arr.length;i++){
			subLst.add(arr[i]);
			subSetsUtil(arr , i + 1,subLst,res);
			subLst.remove(subLst.size() - 1);
		}

	}
}
