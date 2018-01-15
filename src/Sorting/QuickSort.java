package Sorting;

import java.util.Arrays;

/*

QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the
 given array around the picked pivot. There are many different versions of quickSort that pick
 pivot in different ways.

Always pick first element as pivot.
Always pick last element as pivot (implemented below)
Pick a random element as pivot.
Pick median as pivot.
The key process in quickSort is partition(). Target of partitions is, given an array and an
 element x of array as pivot, put x at its correct position in sorted array and put all smaller
 elements (smaller than x) before x, and put all greater elements (greater than x) after x.
 All this should be done in linear time.

 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 3,2,6,10,9,21};

		System.out.println(Arrays.toString(arr));
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr){
		if(arr == null || arr.length == 0){
			return;
		}
		quickSort(arr,0,arr.length - 1);
	}

	public static void quickSort(int[] arr , int start , int end){

		if(start >= end){
			return;
		}

		int partitionIndex = partition(arr , start , end);

		quickSort(arr, start, partitionIndex -1);
		quickSort(arr, partitionIndex + 1, end);
	}

	public static int partition(int[] arr , int start , int end){

		int pivot = arr[end];
		int pIndex = start;

		for(int i = start;i< end;i++){

			if(arr[i] <= pivot){

				swap(arr , pIndex, i);
				pIndex++;
			}
		}
		swap(arr , end, pIndex);


		return pIndex;
	}

	private static void swap(int[] arr , int idx1 , int idx2){
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

}
