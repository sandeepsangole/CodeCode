package array;

import java.util.PriorityQueue;

public class KLargest {

	public static void main(String[] args) {
		int[] arr = {3,2,6,10,9,21};
		System.out.println(kLargest(arr,3));
	}
	/*
			3,2,6,2,10,9,21
	 */
	public static int kLargest(int[] arr , int k){

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i : arr){
			pq.offer(i);
			if(k == 0){
				return pq.peek();
			} else {
				pq.poll();
				k--;
			}
		}

		return -1;
	}
}
