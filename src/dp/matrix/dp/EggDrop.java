package dp.matrix.dp;

public class EggDrop {

	public static void main(String[] args) {

	}

	public int eggDrop(int floors , int eggs){

		if(eggs == 1){
			return floors;
		}

		if(floors == 0){
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for(int i =1;i<=floors;i++){
			int val = Math.max(eggDrop(i - 1, eggs - 1),eggDrop(floors - i , eggs));

			if(val < min){
				min = val;
			}
		}

		return min;

	}
}
