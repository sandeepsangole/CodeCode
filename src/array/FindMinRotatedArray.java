package array;

/*

153. Find Minimum in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

4 5 6 7 0 1 2
      m
6 7 0 1 2 3 4 5
      m

0 1 2 3 4 5 6 7
      m

Find the minimum element.

You may assume no duplicate exists in the array.


 */
public class FindMinRotatedArray {

	public static void main(String[] args) {
		FindMinRotatedArray obj  = new FindMinRotatedArray();
		int[]               arr  = { 4, 5, 6, 7, 0, 1, 2 };
		int[]               arr1 = { 6, 7, 0, 1, 2, 3, 4, 5 };
		int[]               arr2 = { 0, 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(obj.findMin(arr));
		System.out.println(obj.findMin(arr1));
		System.out.println(obj.findMin(arr2));
	}

	public int findMin(int[] nums) {

		return findMin(nums, 0, nums.length - 1);
	}

	public int findMin(int[] nums, int left, int right) {

		if (left == right) {
			return nums[ left ];
		}

		if (left + 1 == right) {
			return Math.min(nums[ left ], nums[ right ]);
		}

		if (nums[ left ] < nums[ right ]) {
			return nums[ left ];
		}

		int mid = (left + right) / 2;

		if (nums[ mid ] < nums[ left ]) {
			return findMin(nums, left, mid);
		} else {
			return findMin(nums, mid, right);
		}

	}
}
