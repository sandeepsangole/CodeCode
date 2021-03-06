package BuySellStock;

/*

121. Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.

 */
public class BuySellStockI {
	public static void main(String[] args) {
		int[] arr = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(arr));
	}

	public static int maxProfit(int[] arr){

		int noStock = 0;
		int oneStock = Integer.MIN_VALUE;

		for(int i =0;i<arr.length;i++){
			System.out.println(noStock +" : "+oneStock +" : "+arr[i]);
			noStock = Math.max(noStock, oneStock + arr[i]);
			oneStock = Math.max(oneStock , -arr[i]);
		}
		return noStock;
	}
}
