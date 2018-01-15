package Sorting;

import java.util.Arrays;

/*
Merge Sort is a Divide and Conquer algorithm. It divides input array in two halves,
calls itself for the two halves and then merges the two sorted halves.
The merge() function is used for merging two halves. The merge(arr, l, m, r) is key process that
assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one.
See following C implementation for details.

MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:
             middle m = (l+r)/2
     2. Call mergeSort for first half:
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)


 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 4,1,34,3,5,63,100,10};

		System.out.println(Arrays.toString(arr));
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));

	}

	public static void mergeSort(int[] arr){

		//if arr size is less than 2 return;
		// create 2 arrays left and right and break arr
		//merge them as per asc order

		if(arr.length < 2){
			return;
		}

		int mid = arr.length /2;

		int[] leftArray = new int[mid];
		int[] rightArray = new int[arr.length - mid];

		for (int i = 0;i< mid;i++){
			leftArray[i] = arr[i];
		}

		int count = 0;
		for(int i = mid;i<arr.length;i++){
			rightArray[count] = arr[i];
			count++;
		}

		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(arr,leftArray,rightArray);
	}

	public static void merge(int[] arr , int[] leftArray , int[] rightArray){

		int leftPointer = 0;
		int rightPointer = 0;
		int mergePointer = 0;

		while(leftPointer < leftArray.length && rightPointer < rightArray.length ) {
			if (leftArray[ leftPointer ] > rightArray[ rightPointer ]) {
				arr[ mergePointer ] = rightArray[ rightPointer ];
				rightPointer++;
			} else {
				arr[ mergePointer ] = leftArray[ leftPointer ];
				leftPointer++;
			}
			mergePointer++;
		}

		if(leftPointer < leftArray.length){
			while(leftPointer < leftArray.length) {
				arr[mergePointer] = leftArray[leftPointer];
				leftPointer++;
				mergePointer++;
			}
		}


		if(rightPointer < rightArray.length){
			while(rightPointer < rightArray.length) {
				arr[mergePointer] = rightArray[rightPointer];
				rightPointer++;
				mergePointer++;
			}
		}

	}
}
