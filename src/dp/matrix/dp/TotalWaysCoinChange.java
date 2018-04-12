package dp.matrix.dp;

	import java.util.*;

	public class TotalWaysCoinChange {

		public static void main(String[] args) {

			TotalWaysCoinChange obj = new TotalWaysCoinChange();
			obj.totalWaysCoinChange(new int[]{1,2,3},5);

			System.out.println(obj.totalWaysMatrixDelete(new int[]{1,2,3},5));
		}

	public List<List<Integer>> totalWaysCoinChange(int[] coins, int total){
		List<List<Integer>> res = new ArrayList<>();
		if(coins == null || coins.length == 0) {
			return res;
		}

		totalWaysDFS(coins,total,res,new ArrayList<>(),0);

		res.stream().forEach(System.out::println);

		return res;
	}

	public void totalWaysDFS(int[] coins , int total , List<List<Integer>> res,List<Integer> subLst, int start){
		if(total == 0){
			res.add(new ArrayList<>(subLst));
		} else {

			for(int i = start;i<coins.length;i++){
				if(total - coins[i] >= 0){
					subLst.add(coins[i]);
					totalWaysDFS(coins,total - coins[i],res,subLst,i);
					subLst.remove(subLst.size() - 1);
				}
			}
		}

	}

	public int totalWaysCoinChangeMatrix(int[] coins, int total){

		return totalWaysMatrix(coins,total);

	}

	public int totalWaysMatrix(int[] coins, int total){

		int[][] cache = new int[coins.length + 1][total + 1];

		for(int i = 0 ; i <= coins.length;i++){
			cache[i][0] = 1;
		}

		for (int i = 1;i <= coins.length;i++){
			for (int j = 1; j <= total ; j++){

				if(coins[i - 1] > j){
					cache[i][j] = cache[i-1][j];
				} else {
					cache[i][j] = cache[i - 1][j] + cache[i][j - coins[i-1]];
				}
			}
		}

		for (int i = 0;i <= coins.length;i++){
			for (int j = 0; j <= total ; j++) {

				System.out.print(cache[i][j] +" ");
			}
			System.out.println();
		}

		return cache[coins.length][total];
	}


	public int totalWaysMatrixDelete(int[] coins, int total){

		int[][] cache = new int[coins.length + 1][ total + 1];

		for(int i = 0;i<coins.length;i++){
			cache[i][0] = 1;
		}

		for(int i = 1;i<= coins.length;i++){
			for(int j = 1;j<= total;j++){

				if(coins[i-1] > j){
					cache[i][j] = cache[i-1][j];
				} else {
					cache[i][j] = cache[i-1][j] + cache[i][j - coins[i-1]];
				}
			}
		}

		return cache[coins.length][total];

	}

}
