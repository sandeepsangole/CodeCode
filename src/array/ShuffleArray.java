package array;

import java.util.Arrays;
import java.util.Random;

/*

Fisher–Yates shuffle Algorithm works in O(n) time complexity. The assumption here is, we are given a
function rand() that generates random number in O(1) time.
The idea is to start from the last element, swap it with a randomly selected element from the whole
array (including last). Now consider the array from 0 to n-2 (size reduced by 1), and repeat the
 process till we hit the first element.

 */
public class ShuffleArray {
	public static void main(String[] args) {
		int[]        arr = {1,2,3,4,5,6,7,8,9,10};
		ShuffleArray obj = new ShuffleArray();
		System.out.println(Arrays.toString(obj.shuffleArray(arr)));
		System.out.println(Arrays.toString(obj.shuffleArray(arr)));
		System.out.println(Arrays.toString(obj.shuffleArray(arr)));
		System.out.println(Arrays.toString(obj.shuffleArray(arr)));
	}

	public int[] shuffleArray(int[] arr){

		Random rand = new Random();

		for(int i = arr.length - 1;i > 0 ;i--){
			int r = rand.nextInt(i);
			swap(arr, i , r);

		}

		return arr;
	}




	private void swap(int[] arr , int index1 , int index2){
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2 ] = tmp;
	}
}
