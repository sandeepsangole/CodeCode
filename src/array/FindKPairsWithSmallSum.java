package array;

import java.util.*;

public class FindKPairsWithSmallSum {

	public static void main(String[] args) {
		List<int[]> arr = kSmallestPairs(new int[] { 1, 7, 11 }, new int[] { 2, 4, 6 }, 3);
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));

		}
	}

	public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> ret = new ArrayList<int[]>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0) return ret;

		//index2 is used for recording position in nums2 corresponding to given position in nums1
		int[] index2 = new int[ nums1.length ];
		while (k-- > 0) {
			int min = Integer.MAX_VALUE;
			//every time we should start from the first place in nums2 to find proper position
			int index = -1;
			for (int index1 = 0; index1 < nums1.length; index1++) {
				if (index2[ index1 ] >= nums2.length) continue;

				if (nums1[ index1 ] + nums2[ index2[ index1 ] ] < min) {
					min = nums1[ index1 ] + nums2[ index2[ index1 ] ];
					//keep record the index in nums1
					index = index1;
				}
			}
			if (index == -1) break;

			int[] temp = { nums1[ index ], nums2[ index2[ index ] ] };
			ret.add(temp);
			index2[ index ]++;
		}
		return ret;
	}
}
