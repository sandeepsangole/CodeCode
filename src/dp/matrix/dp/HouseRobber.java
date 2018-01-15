package dp.matrix.dp;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of
money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have
security system connected and it will automatically contact the police if two adjacent houses were broken
into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the
maximum amount of money you can rob tonight without alerting the police.

 */
public class HouseRobber {

	public static void main(String[] args) {
		int[] arr = {50,10,20,100,80};
                  // 50 50 70 150
		System.out.println(robHouse(arr));

	}

	public static int robHouse(int[] arr){

		int[] cache = new int[ arr.length];
		cache[0] = arr[0];
		cache[1] = Math.max(arr[0],arr[1]);
		//50 50

		for (int i = 2;i < arr.length;i++){
			cache[i] = Math.max(arr[i] + cache[i-2], cache[i-1]);
		}

		return cache[arr.length -1];

	}
}
