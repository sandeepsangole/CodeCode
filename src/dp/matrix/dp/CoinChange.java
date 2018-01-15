package dp.matrix.dp;

public class CoinChange {

	public static void main(String[] args) {

		CoinChange obj = new CoinChange();

		System.out.println(obj.minChange(new int[]{1,2,3},5,new int[6]));
	}

	public int minChange(int[] coins , int total, int[] cache){

		if(total == 0) {
			return 0;
		}

		if(cache[total] != 0){
			return cache[total];
		}

		int min = Integer.MAX_VALUE;

		for(int i = 0; i < coins.length;i++){

			if(total - coins[i] >= 0) {
				int currMin = minChange(coins, total - coins[i],cache);
				if (currMin < min) {
					min = currMin;
				}
			}
		}

		min = min != Integer.MAX_VALUE ? min + 1 : Integer.MAX_VALUE;

		cache[total] = min;

		return cache[total];
	}


}
