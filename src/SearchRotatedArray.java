

/*
33. Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

*/

public class SearchRotatedArray {

	public static void main(String[] args) {
		int[] arr = {7 ,8 ,12, 1, 2,3,4,5};
		SearchRotatedArray obj = new SearchRotatedArray();
		System.out.println(obj.searchinRotatedArray(arr, 5));
		System.out.println(obj.searchinRotatedArray(arr, 12));
		System.out.println(obj.searchinRotatedArray(arr, 7));
	}

	public int searchinRotatedArray(int[] arr , int target){

		if(arr == null || arr.length == 0){
			return -1;
		}

		return searchinRotatedArray(arr , 0 , arr.length - 1,target);
	}

	public int searchinRotatedArray(int[] arr , int start , int end , int target){

		if(start > end){
			return -1;
		}

		int mid = (start + end) / 2;

		System.out.println(" Mid :  "+mid);
		if(arr[mid] == target){
			return mid;
		}

		if(arr[start] <= arr[mid]){
			System.out.println("Inside if ..");
			if(target >= arr[start] && target <= arr[mid]){
				return searchinRotatedArray(arr , start, mid - 1 , target);
			} else {
				return searchinRotatedArray(arr , mid + 1 , end , target);
			}

		}
		else {

			System.out.println("Inside else ..");
			if(target >= arr[mid] && target <= arr[end]){
				return searchinRotatedArray(arr, mid + 1 , end , target);
			} else {
				return searchinRotatedArray(arr , start, mid -1 , target);
			}

		}



	}



}