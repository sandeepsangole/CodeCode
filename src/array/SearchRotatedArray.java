package array;

/*
33. Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

*/

public class SearchRotatedArray {

	public static void main(String[] args) {
		int[] arr = {3 , 1};
		int target = 5;
		SearchRotatedArray obj = new SearchRotatedArray();
		System.out.println(obj.search(arr, 1));

		int[] arr1 = {1};
		System.out.println(obj.findMin(arr1));
	}

	public int search(int[] nums, int target) {

		if(nums == null || nums.length == 0){
			return -1;
		}

		return search(nums, 0 , nums.length - 1, target);

	}

	public int search(int[] arr , int start , int end , int target){

		if(start > end){
			return -1;
		}

		int mid = (start + end) / 2;

		if(arr[mid] == target){
			return mid;
		}

		if(arr[start] <= arr[mid]){

			if(target >= arr[start] && target <= arr[mid]){
				return search(arr, start,mid - 1,target);
			} else {
				return search(arr, mid + 1 ,end,target);
			}
		}

		if(arr[mid] <= arr[end]){

				if(target >= arr[mid] && target <= arr[end]){
					return search(arr,mid + 1, end,target);
				} else{
					return search(arr, start , mid - 1, target);
				}
		}

		return -1;

	}

	public int findMin(int[] arr){

		int start = 0;
		int end = arr.length -1;
		while(start < end){
			int mid = (start + end) /2;
			if(arr[mid] > arr[end]) start = mid + 1;
			else end = mid;
		}
		if(start == end) {
			return arr[start];
		}

		return  start;

	}

}
