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

	List<Integer> list = new ArrayList<>();

	//4  - 9
	@Override
	public void store(int input) {

		for(int n : list){
			sum.add(n+input);
		}
		list.add(input);
	}

	@Override
	public boolean test(int val) {
		return sum.contains(val);
	}

	public static void main(String[] args) {
		TwoSumConstant obj = new TwoSumConstant();
		obj.store(1);
		obj.store(-2);
		obj.store(3);
		obj.store(6);


		System.out.println(obj.test(4));
		System.out.println(obj.test(-1));
		System.out.println(obj.test(9));

		System.out.println(obj.test(10));
		System.out.println(obj.test(5));
		System.out.println(obj.test(0));


	}
}
