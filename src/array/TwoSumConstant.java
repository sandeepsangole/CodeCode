package array;

import java.util.HashMap;

import java.util.*;
/*
	int[] = {1, -2, 3, 6 }
				1 0
			  -2 1
				3 2
				6 3

								map.keyset iterator
								map.containsKey(map.get(key))


	true for 4, -1, and 9, but false for 10, 5, and 0

 */
public class TwoSumConstant implements TwoSum{

	Set<Integer> sum = new HashSet<>();

	@Override
	public void store(int input) {
		Iterator<Integer> it = sum.iterator();
		while (it.hasNext()) {
			int n = it.next();
			sum.add(input + n);
		}

		sum.add(input);
	}

	@Override
	public boolean test(int val) {
		return sum.contains(val);
	}

	public static void main(String[] args) {
		TwoSumConstant obj = new TwoSumConstant();
		obj.store(4);
		obj.store(-1);
		obj.store(9);

		for (int i : obj.sum){
			System.out.print(i +" ");
		}
	}
}
