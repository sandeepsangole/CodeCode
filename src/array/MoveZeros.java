package array;

import java.util.Arrays;

/*
283. Move Zeroes

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of
the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

 */
public class MoveZeros {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(moveZeros(new int[]{0,1,2,0,14})));
	}


	public static int[] moveZeros(int[] arr) {

		int i = 0;
		int j = 0;
		while (j < arr.length) {
			if (arr[ j ] == 0) {
				j++;
			} else {
				arr[ i ] = arr[ j ];
				i++;
				j++;
			}
		}

		while (i < arr.length) {
			arr[ i ] = 0;
			i++;

		}

		return arr;

	}
}
