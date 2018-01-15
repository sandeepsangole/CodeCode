package Permutations;

import java.util.ArrayList;
import java.util.List;

/*

47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

 */
public class PermutationII {

	public static void main(String[] args) {

		int[] ar = {1, 2, 2};
		PermutationII obj = new PermutationII();
		obj.permutations(ar);
	}

	public List<List<Integer>> permutations(int[] arr){

		List<List<Integer>> res = new ArrayList<>();
		if(arr == null || arr.length == 0){
			return res;
		}

		boolean[] used = new boolean[arr.length];
		permutations(arr , new ArrayList<Integer>(),res,used);

		res.stream().forEach(System.out::println);

		return res;
	}

	public void permutations(int[] arr , List<Integer> subLst , List<List<Integer>> res , boolean[] used){
		if(subLst.size() == arr.length){
			res.add(new ArrayList<>(subLst));
		} else {
			for(int i = 0;i<arr.length;i++){
				if(used[i] || (i > 0 && arr[i] == arr[i -1] && used[i - 1])) continue;

				used[i] = true;
				subLst.add(arr[i]);
				permutations(arr,subLst,res,used);
				used[i] = false;

				subLst.remove(subLst.size() - 1);

				}
		}
	}

}
