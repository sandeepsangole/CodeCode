package array;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		rotate(arr,3);
		System.out.println(Arrays.toString(arr));
	}


	public static void rotate(int[] nums, int k) {
		int len = nums.length - 1;

		swap(nums, 0, k -1);
		swap(nums, k, len);
		swap(nums, 0, len);
	}

	public static void swap(int[] nums , int start , int end){
		while(start < end){
			int tmp = nums[start];
			nums[start++]=nums[end];
			nums[end--] = tmp;
		}
	}
}
