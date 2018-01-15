package Permutations;

/*

46. Permutations

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

 */

import java.util.*;

public class PermutationsI {

	public static void main(String[] args) {

		int[]         ar  = { 1, 2, 3 };
		PermutationsI obj = new PermutationsI();
		obj.permutations(ar);
	}

	public List<List<Integer>> permutations(int[] arr) {

		List<List<Integer>> res = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return res;
		}

		permutations(arr, new ArrayList<Integer>(), res);

		res.stream().forEach(System.out::println);

		return res;
	}

	public void permutations(int[] arr, List<Integer> subLst, List<List<Integer>> res) {
		if (subLst.size() == arr.length) {
			res.add(new ArrayList<>(subLst));
		} else {

			for (int i = 0; i < arr.length; i++) {
				if (subLst.contains(arr[ i ])) continue;

				subLst.add(arr[ i ]);
				permutations(arr, subLst, res);
				subLst.remove(subLst.size() - 1);

			}


		}

	}

}
