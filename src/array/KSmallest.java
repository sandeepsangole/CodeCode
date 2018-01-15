package array;

import java.util.Arrays;

/*
	Use Quick sort. Based on K , get rid of half part of array
 */
public class KSmallest {


	public static void main(String[] args) {
		KSmallest obj = new KSmallest();
		int[] arr = {3,2,6,10,9,21};
		obj.kSmallest(arr,2);
	}

	public void kSmallest(int[] arr , int k){
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0 , arr.length - 1, k);
		System.out.println(Arrays.toString(arr));
	}

	public int quickSort(int[] arr, int start , int end, int k){

		if(start >= end){
			return -1;
		}

		int pIndex = findPartitionIndex(arr,start,end);

		if(pIndex == k){
			System.out.println(arr[pIndex]);
		}
		if(pIndex == k - 1){
			return arr[pIndex];
		}
		if(pIndex >  k -1) {
			return quickSort(arr, start, pIndex -1, k);
		} else {
			return quickSort(arr, pIndex + 1, end, k);
		}


	}

	public int findPartitionIndex(int[] arr , int start , int end){

		int pivot = arr[end];
		int pIndex = start;

		for (int i = start;i< end;i++){

			if (arr[i] <= pivot){
				swap(arr ,i,pIndex);
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
